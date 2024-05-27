package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.dto.FollowDTO;
import org.serratec.trabalho.grupo1.exception.NotFoundException;
import org.serratec.trabalho.grupo1.exception.UnauthorizedActionException;
import org.serratec.trabalho.grupo1.model.Comentario;
import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.repository.ComentarioRepository;
import org.serratec.trabalho.grupo1.repository.PublicacaoRepository;
import org.serratec.trabalho.grupo1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    public List<Comentario> listar() {
        return comentarioRepository.findAll();
    }

    public Comentario buscar(Long id) {
        Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
        return comentarioOpt.orElse(null);
    }

    public Comentario inserir(Comentario comentario) {
        Long usuarioSeguidoId = publicacaoRepository
                .findById(comentario.getPublicacao().getId())
                .orElseThrow(NotFoundException::new)
                .getAutor()
                .getId();

        List<Object[]> teste = usuarioRepository.findAllFollowers(usuarioSeguidoId);


        List<FollowDTO> usuarioSeguidoFollows = usuarioRepository.findAllFollowersById(usuarioSeguidoId);

        for (FollowDTO follow : usuarioSeguidoFollows) {
            if (follow.getIdSeguidor() == comentario.getAutor().getId()) {
                comentario.setDataCriacao(LocalDate.now());
                return comentarioRepository.save(comentario);
            }
        }

        throw new UnauthorizedActionException();
    }

    public Comentario atualizar(Long id, Comentario novoComentario) {
        Optional<Comentario> optionalComentario = comentarioRepository.findById(id);
        if (optionalComentario.isPresent()) {
            novoComentario.setId(id);
            novoComentario.setDataCriacao(LocalDate.now());
            return comentarioRepository.save(novoComentario);
        } else {
            // Exception
            return null;
        }
    }

    public void delete(Long id) {
        comentarioRepository.deleteById(id);
    }
}
