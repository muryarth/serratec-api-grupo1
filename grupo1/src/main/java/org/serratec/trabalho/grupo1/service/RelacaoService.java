package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.model.Comentario;
import org.serratec.trabalho.grupo1.model.Relacao;
import org.serratec.trabalho.grupo1.repository.ComentarioRepository;
import org.serratec.trabalho.grupo1.repository.RelacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelacaoService {
    @Autowired
    private RelacaoRepository relacaoRepository;

    public List<Relacao> findAll () {
        List<Relacao> relacao = relacaoRepository.findAll();
        return relacao;
    }

    public Relacao buscar(Long id) {
        Optional<Relacao> relacaoOpt = relacaoRepository.findById(id);
        return relacaoOpt.get();
    }

    public Object inserir(Relacao relacao) {
        return relacaoRepository.save(relacao);
    }

    public Relacao atualizar(Long id, Relacao novaRelacao) {
        Optional<Relacao> optionalRelacao = relacaoRepository.findById(id);
        if (optionalRelacao.isPresent()) {
            novaRelacao.setId(id);
            return (Relacao) relacaoRepository.save(novaRelacao);
        } else {
            // Exception
            return null;
        }
    }

    public void delete(Long id){
        relacaoRepository.deleteById(id);
    }

}
