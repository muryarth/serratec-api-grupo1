package org.serratec.trabalho.grupo1.controller;

import jakarta.validation.Valid;
import org.serratec.trabalho.grupo1.dto.PublicacaoDTO;
import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.service.PublicacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    private final PublicacaoService publicacaoService;

    private PublicacaoController(PublicacaoService publicacaoService) {
        this.publicacaoService = publicacaoService;
    }

    @GetMapping
    public ResponseEntity<List<PublicacaoDTO>> listAll() {
        List<PublicacaoDTO> publicacoesDTO = publicacaoService.findAll();
        return ResponseEntity.ok(publicacoesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacaoDTO> listById(@PathVariable Long id) {
        PublicacaoDTO publicacaoDTO = publicacaoService.findById(id);
        return ResponseEntity.ok(publicacaoDTO);
    }

    @PostMapping
    public ResponseEntity<PublicacaoDTO> create(@Valid @RequestBody Publicacao publicacao) {
        PublicacaoDTO publicacaoDTO = publicacaoService.create(publicacao);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(publicacaoDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(publicacaoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacaoDTO> update(@PathVariable Long id, @Valid @RequestBody Publicacao novaPublicacao) {
        PublicacaoDTO publicacaoDTO = publicacaoService.findAndUpdate(id, novaPublicacao);
        return ResponseEntity.ok(publicacaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        publicacaoService.findAndDelete(id);

        return ResponseEntity.noContent().build();
    }
}