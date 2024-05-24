package org.serratec.trabalho.grupo1.controller;

import java.util.List;

import org.serratec.trabalho.grupo1.dto.UsuarioDTO;
import org.serratec.trabalho.grupo1.model.Relacao;
import org.serratec.trabalho.grupo1.service.RelacaoService;
import org.serratec.trabalho.grupo1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relacoes")
public class RelacaoController {
    @Autowired
    private RelacaoService relacaoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Relacao>> listar() {
        List<Relacao> relacoes = relacaoService.findAll();
        return ResponseEntity.ok(relacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relacao> buscar(@PathVariable Long id) {
        Relacao relacao = relacaoService.findById(id);
        if (relacao != null) {
            return ResponseEntity.ok().body(relacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Relacao> criar(@RequestParam Long seguidorId, @RequestParam Long seguidoId) {
        UsuarioDTO seguidor = usuarioService.findById(seguidorId);
        UsuarioDTO seguido = usuarioService.findById(seguidoId);
        Relacao novaRelacao = new Relacao(seguidor, seguido);
        relacaoService.save(novaRelacao);
        return ResponseEntity.ok(novaRelacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        relacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
