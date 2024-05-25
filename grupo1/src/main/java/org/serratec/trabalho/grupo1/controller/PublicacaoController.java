package org.serratec.trabalho.grupo1.controller;

import java.net.URI;
import java.util.List;

import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.service.PublicacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    private final PublicacaoService publicacaoService;

    public PublicacaoController(PublicacaoService publicacaoService) {
        this.publicacaoService = publicacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Publicacao>> listAll() {
        List<Publicacao> publicacoes = publicacaoService.findAll();
        return ResponseEntity.ok(publicacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacao> listById(@PathVariable Long id) {
        Publicacao publicacao = publicacaoService.findById(id);
        return ResponseEntity.ok(publicacao);
    }

    @PostMapping
    public ResponseEntity<Publicacao> create(@Valid @RequestBody Publicacao publicacao) {
        Publicacao novaPublicacao = publicacaoService.create(publicacao);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaPublicacao.getId())
                .toUri();

        return ResponseEntity.created(uri).body(novaPublicacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacao> update(@PathVariable Long id, @Valid @RequestBody Publicacao novaPublicacao) {
        Publicacao publicacaoAtualizada = publicacaoService.findAndUpdate(id, novaPublicacao);
        return ResponseEntity.ok(publicacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        publicacaoService.findAndDelete(id);
        return ResponseEntity.noContent().build();
    }
}
