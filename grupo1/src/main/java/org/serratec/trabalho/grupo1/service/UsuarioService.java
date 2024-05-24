package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.dto.RelacaoDTO;
import org.serratec.trabalho.grupo1.dto.UsuarioDTO;
import org.serratec.trabalho.grupo1.exception.NoContentException;
import org.serratec.trabalho.grupo1.exception.NotFoundException;
import org.serratec.trabalho.grupo1.model.Relacao;
import org.serratec.trabalho.grupo1.model.Usuario;
import org.serratec.trabalho.grupo1.repository.RelacaoRepository;
import org.serratec.trabalho.grupo1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RelacaoRepository relacaoRepository;
    

    public List<UsuarioDTO> findAll() {
		 List<Usuario> usuarios = usuarioRepository.findAll();
		 
		 List<UsuarioDTO> usuarioDTO = new ArrayList<>();
		 
		 for (Usuario usuario: usuarios) {
			 UsuarioDTO usuDTO = new UsuarioDTO(usuario);
			 usuarioDTO.add(usuDTO);
		 }
		 return usuarioDTO;
    }
    
    public UsuarioDTO findById(Long id) throws NotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            throw new NotFoundException();
        }
        return new UsuarioDTO(usuarioOpt.get());
    }
    
    public UsuarioDTO create(Usuario usuario){
        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }
    
    public UsuarioDTO alterar(Long id,  Usuario novoUsuario) {
    	Optional<Usuario> usuOPT= usuarioRepository.findById(id);
    	if(!usuOPT.isPresent()) {
    		throw new NotFoundException();
    	}
    	novoUsuario.setId(id);
    	return new UsuarioDTO(usuarioRepository.save(novoUsuario));
    }
    
    public void deletar(Long id) throws NotFoundException {
    	Optional<Usuario> usuOPT= usuarioRepository.findById(id);
    	if(!usuOPT.isPresent()) {
    		throw new NotFoundException();
    	}
    	usuarioRepository.deleteById(id);	
    }

    /* Referente à relações */
    
    public List<RelacaoDTO> findAllFollowersById(Long id) throws NotFoundException, NoContentException {

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if(usuarioOpt.isPresent()){
            List<Relacao> relacoes = relacaoRepository.findAllFollowersByUserId(id);
            List<RelacaoDTO> relacoesDTO = new ArrayList<>();

            for(Relacao relacao : relacoes){
                RelacaoDTO relacaoDTO = new RelacaoDTO(relacao);
                relacoesDTO.add(relacaoDTO);
            }

            if(!relacoesDTO.isEmpty()){
                return relacoesDTO;
            }

            throw new NoContentException();
        }

        throw new NotFoundException();
    }

    public List<RelacaoDTO> findAllFollowingById(Long id) throws NotFoundException, NoContentException {

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if(usuarioOpt.isPresent()){
            List<Relacao> relacoes = relacaoRepository.findAllFollowingById(id);
            List<RelacaoDTO> relacoesDTO = new ArrayList<>();

            for(Relacao relacao : relacoes){
                RelacaoDTO relacaoDTO = new RelacaoDTO(relacao);
                relacoesDTO.add(relacaoDTO);
            }

            if(!relacoesDTO.isEmpty()){
                return relacoesDTO;
            }

            throw new NoContentException();
        }

        throw new NotFoundException();
    }
}