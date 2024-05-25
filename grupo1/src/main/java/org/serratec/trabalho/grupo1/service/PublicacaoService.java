package org.serratec.trabalho.grupo1.service;

import java.util.List;
import java.util.Optional;

import org.serratec.trabalho.grupo1.exception.NotFoundException;
import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacaoService {

    @Autowired
    private final PublicacaoRepository publicacaoRepository;

    public PublicacaoService(PublicacaoRepository publicacaoRepository) {
        this.publicacaoRepository = publicacaoRepository;
    }

    public List<Publicacao> findAll() {
        return publicacaoRepository.findAll();
    }

    public Publicacao findById(Long id) {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(id);
        if (publicacaoOpt.isPresent()) {
            return publicacaoOpt.get();
        }
        throw new NotFoundException();
    }

    public Publicacao create(Publicacao publicacao) {
        return publicacaoRepository.save(publicacao);
    }

    public Publicacao findAndUpdate(Long id, Publicacao novaPublicacao) {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(id);
        if (publicacaoOpt.isPresent()) {
            Publicacao publicacao = publicacaoOpt.get();
            publicacao.setConteudo(novaPublicacao.getConteudo());
            publicacao.setDataCriacao(novaPublicacao.getDataCriacao());
            publicacao.setComentarios(novaPublicacao.getComentarios());
            return publicacaoRepository.save(publicacao);
        }
        throw new NotFoundException();
    }

    public void findAndDelete(Long id) {
        if (!publicacaoRepository.existsById(id)) {
            throw new NotFoundException();
        }
        publicacaoRepository.deleteById(id);
    }
}
