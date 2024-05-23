package org.serratec.trabalho.grupo1.controller;

import jakarta.validation.Valid;
import org.serratec.trabalho.grupo1.model.Comentario;
import org.serratec.trabalho.grupo1.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    private Comentario comentario;

    @GetMapping
    public ResponseEntity<List<Comentario>> listar() {
        return ResponseEntity.ok(comentarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscar(@PathVariable Long id) {
        Comentario comentarioPorId = comentarioService.buscar(id);
        if (comentarioPorId != null) {
            return ResponseEntity.ok().body(comentarioPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Comentario> inserirComentario(@Valid @RequestBody Comentario comentario) {
        Comentario novoComentario = comentarioService.inserir(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoComentario);
    }

//    @PostMapping
//    public ResponseEntity<Comentario> inserir() {
//        return ResponseEntity.ok(comentarioService.inserir());
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> atualizar(@PathVariable Long id, @RequestBody Comentario comentario) {
        Comentario atualizarComentario = comentarioService.atualizar(id,comentario);
        return ResponseEntity.ok().body(atualizarComentario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comentario> deletar(@PathVariable Long id) {
        Comentario deletarComentario = comentarioService.delete(id);
        return ResponseEntity.ok().body(deletarComentario);
    }

}
