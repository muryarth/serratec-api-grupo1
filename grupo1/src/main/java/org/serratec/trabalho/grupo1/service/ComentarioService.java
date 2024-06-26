package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.dto.ComentarioDTO;
import org.serratec.trabalho.grupo1.dto.ComentarioEditadoDTO;
import org.serratec.trabalho.grupo1.dto.FollowDTO;
import org.serratec.trabalho.grupo1.dto.PublicacaoDTO;
import org.serratec.trabalho.grupo1.exception.NoContentException;
import org.serratec.trabalho.grupo1.exception.NotFoundException;
import org.serratec.trabalho.grupo1.exception.UnauthorizedActionException;
import org.serratec.trabalho.grupo1.model.Comentario;
import org.serratec.trabalho.grupo1.model.NovoComentarioDTO;
import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.model.Usuario;
import org.serratec.trabalho.grupo1.repository.ComentarioRepository;
import org.serratec.trabalho.grupo1.repository.PublicacaoRepository;
import org.serratec.trabalho.grupo1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<ComentarioDTO> listar() {

        List<Comentario> comentarios = comentarioRepository.findAll();

        return comentarios.stream().map(ComentarioDTO::new).toList();
    }

    public ComentarioDTO buscar(Long id) {
        Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);

        if(comentarioOpt.isEmpty()){
            throw new NotFoundException();
        }

        return new ComentarioDTO(comentarioOpt.get());
    }

    public ComentarioDTO inserir(NovoComentarioDTO novoComentario) {
        Optional<Usuario> autorOpt = usuarioRepository.findById(novoComentario.getIdAutor());
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(novoComentario.getIdPublicacao());

        if (autorOpt.isEmpty() || publicacaoOpt.isEmpty()){
            throw new NotFoundException();
        }

        Comentario comentario = new Comentario(novoComentario.getTexto(),publicacaoOpt.get(),  autorOpt.get());

        Long usuarioSeguidoId = publicacaoRepository
                .findById(comentario.getPublicacao().getId())
                .orElseThrow(NotFoundException::new)
                .getAutor()
                .getId();

        List<Object[]> usuarioSeguidoFollows = usuarioRepository.findAllFollowersById(usuarioSeguidoId);
        List<FollowDTO> usuarioSeguidoFollowsDTO = new ArrayList<>();

        for(Object[] usuario : usuarioSeguidoFollows){
            FollowDTO follow = new FollowDTO(usuario);
            usuarioSeguidoFollowsDTO.add(follow);
        }

        for (FollowDTO follow : usuarioSeguidoFollowsDTO) {
            if (follow.getIdSeguidor() == comentario.getAutor().getId()) {
                comentario.setDataCriacao(LocalDate.now());
                return new ComentarioDTO(comentarioRepository.save(comentario));
            }
        }

        throw new UnauthorizedActionException("Não é possível comentar se não segue o usuário.");
    }

    public Comentario atualizar(Long id, ComentarioEditadoDTO comentarioEditadoDTO) {
        Optional<Comentario> optionalComentario = comentarioRepository.findById(id);

        if (optionalComentario.isPresent()) {

            Comentario comentarioEditado = new Comentario();

            comentarioEditado.setId(id);
            comentarioEditado.setDataCriacao(optionalComentario.get().getDataCriacao());
            comentarioEditado.setTexto(comentarioEditadoDTO.getTexto());
            comentarioEditado.setPublicacao(optionalComentario.get().getPublicacao());
            comentarioEditado.setAutor(optionalComentario.get().getAutor());
            return comentarioRepository.save(comentarioEditado);
        }

        throw new NotFoundException();
    }

    public void delete(Long id) {
        comentarioRepository.deleteById(id);
    }
}
