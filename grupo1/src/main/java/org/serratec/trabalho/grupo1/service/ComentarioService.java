package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.model.Comentario;
import org.serratec.trabalho.grupo1.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> findAll () {
        List<Comentario> comentarios = comentarioRepository.findAll();
        return comentarios;
    }

    public Comentario buscar(Long id) {
        Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
        return comentarioOpt.get();
    }

    public Object inserir(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario atualizar(Long id, Comentario novoComentario) {
        Optional<Comentario> optionalComentario = comentarioRepository.findById(id);
        if (optionalComentario.isPresent()) {
            novoComentario.setId(id);
            return (Comentario) comentarioRepository.save(novoComentario);
        } else {
            // Exception
            return null;
        }
    }

    public void delete(Long id){
        comentarioRepository.deleteById(id);
    }

}
