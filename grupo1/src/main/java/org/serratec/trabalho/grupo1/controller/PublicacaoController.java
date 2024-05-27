package org.serratec.trabalho.grupo1.controller;

import java.net.URI;
import java.util.List;

import org.serratec.trabalho.grupo1.dto.PublicacaoDTO;
import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.service.PublicacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<PublicacaoDTO>> listAll() {
        List<PublicacaoDTO> publicacoes = publicacaoService.findAll();
        return ResponseEntity.ok(publicacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacaoDTO> listById(@PathVariable Long id) {
        PublicacaoDTO publicacao = publicacaoService.findById(id);
        return ResponseEntity.ok(publicacao);
    }

    @PostMapping
    public ResponseEntity<PublicacaoDTO> create(@Valid @RequestBody Publicacao publicacao) {
        PublicacaoDTO novaPublicacao = publicacaoService.create(publicacao);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaPublicacao.getId())
                .toUri();

        return ResponseEntity.created(uri).body(novaPublicacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacaoDTO> update(@PathVariable Long id, @Valid @RequestBody Publicacao novaPublicacao) {
        PublicacaoDTO publicacaoAtualizada = publicacaoService.findAndUpdate(id, novaPublicacao);
        return ResponseEntity.ok(publicacaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        publicacaoService.findAndDelete(id);
        return ResponseEntity.noContent().build();
    }
}
