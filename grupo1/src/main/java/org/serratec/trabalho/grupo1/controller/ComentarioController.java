package org.serratec.trabalho.grupo1.controller;

import jakarta.validation.Valid;
import org.serratec.trabalho.grupo1.dto.ComentarioDTO;
import org.serratec.trabalho.grupo1.dto.ComentarioEditadoDTO;
import org.serratec.trabalho.grupo1.model.Comentario;
import org.serratec.trabalho.grupo1.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> listar() {
        return ResponseEntity.ok(comentarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> buscar(@PathVariable Long id) {
        ComentarioDTO comentarioPorId = comentarioService.buscar(id);
        if (comentarioPorId != null) {
            return ResponseEntity.ok().body(comentarioPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> inserirComentario(@Valid @RequestBody Comentario comentario) {
        ComentarioDTO novoComentario = comentarioService.inserir(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoComentario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> atualizar(@PathVariable Long id, @RequestBody ComentarioEditadoDTO comentarioEditado) {
        Comentario atualizarComentario = comentarioService.atualizar(id, comentarioEditado);
        return ResponseEntity.ok().body(atualizarComentario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        comentarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
