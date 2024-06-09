package org.serratec.trabalho.grupo1.controller;

import java.util.List;

import org.serratec.trabalho.grupo1.dto.JogoResponseDTO;
import org.serratec.trabalho.grupo1.model.Jogo;
import org.serratec.trabalho.grupo1.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<JogoResponseDTO>> listarJogos(){
        return ResponseEntity.ok(jogoService.listarJogos());
    }

    @PostMapping
    public ResponseEntity<JogoResponseDTO> inserirJogo(@RequestBody Jogo jogo){
        return ResponseEntity.ok(jogoService.inserirJogo(jogo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> atualizarJogo(@PathVariable Long id, @RequestBody Jogo jogo) throws NotFoundException{
        return ResponseEntity.ok(jogoService.atualizarJogo(id, jogo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogo(@PathVariable Long id) throws NotFoundException{
        jogoService.deletarJogo(id);
        return ResponseEntity.noContent().build();
    }
}
