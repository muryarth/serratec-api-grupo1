package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.dto.PublicacaoDTO;
import org.serratec.trabalho.grupo1.exception.NotFoundException;
import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.repository.PublicacaoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public PublicacaoDTO findById(Long id){
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(id);

        if(publicacaoOpt.isPresent()){
            return new PublicacaoDTO(publicacaoOpt.get());
        }

        throw new NotFoundException();
    }

    public PublicacaoDTO create(Publicacao publicacao){

        publicacaoRepository.save(publicacao);

        return new PublicacaoDTO(publicacao);

    }

}
