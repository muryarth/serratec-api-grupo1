package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.model.Comentario;
import org.serratec.trabalho.grupo1.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> listar() {
        return comentarioRepository.findAll();
    }

    public Comentario buscar(Long id) {
        Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
        return comentarioOpt.orElse(null);
    }

    public Comentario inserir(Comentario comentario) {
        comentario.setDataCriacao(LocalDate.now());
        return comentarioRepository.save(comentario);
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
