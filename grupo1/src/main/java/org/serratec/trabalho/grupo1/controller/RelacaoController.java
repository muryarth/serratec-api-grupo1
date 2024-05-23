package org.serratec.trabalho.grupo1.controller;

import jakarta.validation.Valid;
import org.serratec.trabalho.grupo1.model.Comentario;
import org.serratec.trabalho.grupo1.model.Relacao;
import org.serratec.trabalho.grupo1.service.ComentarioService;
import org.serratec.trabalho.grupo1.service.RelacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relacoes")
public class RelacaoController {

    @Autowired
    private RelacaoService relacaoService;

    private Relacao relacao;

    @GetMapping
    public ResponseEntity<List<Relacao>> listar() {
        return ResponseEntity.ok(relacaoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relacao> buscar(@PathVariable Long id) {
        Relacao relacaoPorId = relacaoService.buscar(id);
        if (relacaoPorId != null) {
            return ResponseEntity.ok().body(relacaoPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Relacao> atualizar(@PathVariable Long id, @RequestBody Relacao relacao) {
        Relacao atualizarRelacao = relacaoService.atualizar(id,relacao);
        return ResponseEntity.ok().body(atualizarRelacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Relacao> deletar(@PathVariable Long id) {
        Relacao deletarRelacao = relacaoService.delete(id);
        return ResponseEntity.ok().body(deletarRelacao);
    }

}