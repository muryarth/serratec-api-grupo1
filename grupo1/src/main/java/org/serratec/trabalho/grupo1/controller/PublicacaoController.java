package org.serratec.trabalho.grupo1.controller;

import org.serratec.trabalho.grupo1.dto.PublicacaoDTO;
import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.service.PublicacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<PublicacaoDTO> create(@RequestBody Publicacao publicacao) {
        PublicacaoDTO publicacaoDTO = publicacaoService.create(publicacao);

        return ResponseEntity.ok(publicacaoDTO);
    }

}
