package org.serratec.trabalho.grupo1.controller;

import org.serratec.trabalho.grupo1.dto.PublicacaoDTO;
import org.serratec.trabalho.grupo1.service.PublicacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    private final PublicacaoService publicacaoService;

    private PublicacaoController(PublicacaoService publicacaoService) {
        this.publicacaoService = publicacaoService;
    }

    @GetMapping
    public ResponseEntity<List<PublicacaoDTO>> listar() {
        List<PublicacaoDTO> publicacoes = publicacaoService.findAll();
        return ResponseEntity.ok(publicacoes);
    }

}
