package org.serratec.trabalho.grupo1.service;

import jakarta.transaction.Transactional;
import org.serratec.trabalho.grupo1.dto.RelacaoDTO;
import org.serratec.trabalho.grupo1.dto.UsuarioDTO;
import org.serratec.trabalho.grupo1.exception.*;
import org.serratec.trabalho.grupo1.model.Relacao;
import org.serratec.trabalho.grupo1.model.RelacaoPK;
import org.serratec.trabalho.grupo1.model.Usuario;
import org.serratec.trabalho.grupo1.repository.RelacaoRepository;
import org.serratec.trabalho.grupo1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
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

        for (Usuario usuario : usuarios) {
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

    public UsuarioDTO create(Usuario usuario) {
        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    public UsuarioDTO update(Long id, Usuario novoUsuario) {
        Optional<Usuario> usuOPT = usuarioRepository.findById(id);
        if (!usuOPT.isPresent()) {
            throw new NotFoundException();
        }
        novoUsuario.setId(id);
        return new UsuarioDTO(usuarioRepository.save(novoUsuario));
    }

    public void deletar(Long id) throws NotFoundException {
        Optional<Usuario> usuOPT = usuarioRepository.findById(id);
        if (!usuOPT.isPresent()) {
            throw new NotFoundException();
        }
        usuarioRepository.deleteById(id);
    }

    /* Referente ao follow de usuários */

    public List<RelacaoDTO> findAllFollowersById(Long id) throws NotFoundException, NoContentException {

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isPresent()) {
            List<Relacao> relacoes = relacaoRepository.findAllFollowersByUserId(id);
            List<RelacaoDTO> relacoesDTO = new ArrayList<>();

            for (Relacao relacao : relacoes) {
                RelacaoDTO relacaoDTO = new RelacaoDTO(relacao);
                relacoesDTO.add(relacaoDTO);
            }

            if (!relacoesDTO.isEmpty()) {
                return relacoesDTO;
            }

            throw new NoContentException();
        }

        throw new NotFoundException();
    }

    public List<RelacaoDTO> findAllFollowingById(Long id) throws NotFoundException, NoContentException {

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isPresent()) {
            List<Relacao> relacoes = relacaoRepository.findAllFollowingById(id);
            List<RelacaoDTO> relacoesDTO = new ArrayList<>();

            for (Relacao relacao : relacoes) {
                RelacaoDTO relacaoDTO = new RelacaoDTO(relacao);
                relacoesDTO.add(relacaoDTO);
            }

            if (!relacoesDTO.isEmpty()) {
                return relacoesDTO;
            }

            throw new NoContentException();
        }

        throw new NotFoundException();
    }

    public RelacaoDTO giveFollow(Long seguidoId, Long seguidorId) {

        Optional<Usuario> seguidoOpt = usuarioRepository.findById(seguidoId);
        Optional<Usuario> seguidorOpt = usuarioRepository.findById(seguidorId);

        if (seguidoOpt.isPresent() && seguidorOpt.isPresent()) {

            Optional<Relacao> relacaoOpt = relacaoRepository.findByCompositeId(seguidoId, seguidorId);

            if (relacaoOpt.isEmpty()) {
                if (!seguidorOpt.get().equals(seguidoOpt.get())) {
                    return new RelacaoDTO(relacaoRepository.save(
                            new Relacao(new RelacaoPK(seguidoOpt.get(), seguidorOpt.get()), LocalDate.now())
                    ));
                }

                // Exception para quando IDs iguais são encontrados
                throw new IncompatibleEqualsException();
            }

            // Exception para quando tenta criar um follow que já estava criado
            throw new DuplicateItemException();
        }

        throw new NotFoundException();
    }

    public void removeFollow(Long seguidoId, Long seguidorId) {
        Optional<Relacao> relacaoOpt = relacaoRepository.findByCompositeId(seguidoId, seguidorId);

        if (relacaoOpt.isEmpty()) {
            throw new NotFoundException();
        }

        relacaoRepository.deleteByCompositeId(seguidoId, seguidorId);
    }
}