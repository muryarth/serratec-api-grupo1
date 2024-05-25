package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.dto.RelacaoDTO;
import org.serratec.trabalho.grupo1.dto.UsuarioDTO;
import org.serratec.trabalho.grupo1.dto.UsuarioInserirDTO;
import org.serratec.trabalho.grupo1.exception.EmailException;
import org.serratec.trabalho.grupo1.exception.NoContentException;
import org.serratec.trabalho.grupo1.exception.NotFoundException;
import org.serratec.trabalho.grupo1.exception.SenhaException;
import org.serratec.trabalho.grupo1.model.Perfil;
import org.serratec.trabalho.grupo1.model.Relacao;
import org.serratec.trabalho.grupo1.model.Usuario;
import org.serratec.trabalho.grupo1.model.UsuarioPerfil;
import org.serratec.trabalho.grupo1.repository.RelacaoRepository;
import org.serratec.trabalho.grupo1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {
	@Autowired
	private PerfilService perfilService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RelacaoRepository relacaoRepository;
    
	@Autowired
	private BCryptPasswordEncoder encoder;

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
    
    @Transactional
	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) throws EmailException, SenhaException {
		if (!usuarioInserirDTO.getSenha().equalsIgnoreCase(usuarioInserirDTO.getConfirmaSenha())) {
			throw new SenhaException("Senha e Confirma Senha não são iguais");
		}
		Usuario usuarioBd = usuarioRepository.findByEmail(usuarioInserirDTO.getEmail());
		if (usuarioBd != null) {
			throw new EmailException("Email ja existente");
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setSenha(encoder.encode(usuarioInserirDTO.getSenha()));
		
		Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();
		for(Perfil perfil: usuarioInserirDTO.getPerfis()) {
			perfil = perfilService.buscar(perfil.getId());
			UsuarioPerfil usuarioPerfil = new UsuarioPerfil(usuario, perfil, LocalDate.now());
			usuarioPerfis.add(usuarioPerfil);
		}
		
		usuario.setUsuarioPerfis(usuarioPerfis);
		
		usuario = usuarioRepository.save(usuario);
		
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return usuarioDTO;
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