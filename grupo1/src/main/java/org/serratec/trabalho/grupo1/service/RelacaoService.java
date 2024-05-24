package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.model.Relacao;
import org.serratec.trabalho.grupo1.repository.RelacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelacaoService {
    @Autowired
    private RelacaoRepository relacaoRepository;

    public List<Relacao> findAll() {
        return relacaoRepository.findAll();
    }

    public Relacao findById(Long id) {
        return relacaoRepository.findById(id).orElse(null);
    }

    public Relacao save(Relacao relacao) {
        return relacaoRepository.save(relacao);
    }

    public void deleteById(Long id) {
        relacaoRepository.deleteById(id);
    }
}
