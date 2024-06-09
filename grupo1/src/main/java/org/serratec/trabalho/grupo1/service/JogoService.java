package org.serratec.trabalho.grupo1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.trabalho.grupo1.dto.JogoResponseDTO;
import org.serratec.trabalho.grupo1.model.Jogo;
import org.serratec.trabalho.grupo1.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepository;
    public List<JogoResponseDTO> listarJogos() {
        List <Jogo> jogos = jogoRepository.findAll();
        List <JogoResponseDTO> jogosResponseDTO = new ArrayList <>();
        for (Jogo jogo: jogos) {

            JogoResponseDTO jogoDTO = new JogoResponseDTO(jogo);
            jogosResponseDTO.add(jogoDTO);
        }
        return jogosResponseDTO;


    }
    public JogoResponseDTO inserirJogo(Jogo novoJogo) {

        return new JogoResponseDTO(jogoRepository.save(novoJogo));
    }

    public JogoResponseDTO atualizarJogo(Long id, Jogo jogo) throws NotFoundException{

        Optional<Jogo> jogoOpt = jogoRepository.findById(id);

        if(jogoOpt.isEmpty()) {
            throw new NotFoundException();
        }

        jogo.setId(id);
        return new JogoResponseDTO( jogoRepository.save(jogo) );

    }

    public void deletarJogo(Long id) throws NotFoundException {
        Optional<Jogo> jogoOpt = jogoRepository.findById(id);

        if(jogoOpt.isEmpty()) {
            throw new NotFoundException();
        }

        jogoRepository.deleteById(id);
    }

}