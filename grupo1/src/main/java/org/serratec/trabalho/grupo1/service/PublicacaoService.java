package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.dto.PublicacaoDTO;
import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.repository.PublicacaoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicacaoService {

    private final PublicacaoRepository publicacaoRepository;

    private PublicacaoService(PublicacaoRepository publicacaoRepository) {
        this.publicacaoRepository = publicacaoRepository;
    }

    public List<PublicacaoDTO> findAll(){
        List<Publicacao> publicacoes = publicacaoRepository.findAll();

        List<PublicacaoDTO> publicacoesDTO = new ArrayList<>();

        for(Publicacao publicacao : publicacoes) {
            PublicacaoDTO publiDTO = new PublicacaoDTO(publicacao);
            publicacoesDTO.add(publiDTO);
        }

        // List<PublicacaoDTO> publicacoesDTO = publicacoes.stream().map(PublicacaoDTO::new).toList();

        return publicacoesDTO;
    }

}
