package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.dto.PublicacaoDTO;
import org.serratec.trabalho.grupo1.exception.ForeignKeyMustBeNullException;
import org.serratec.trabalho.grupo1.exception.NotFoundException;
import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.model.Usuario;
import org.serratec.trabalho.grupo1.repository.PublicacaoRepository;
import org.serratec.trabalho.grupo1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PublicacaoService {

    @Autowired
    private final PublicacaoRepository publicacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public PublicacaoService(PublicacaoRepository publicacaoRepository) {
        this.publicacaoRepository = publicacaoRepository;
    }

    public List<PublicacaoDTO> findAll() {
        List<Publicacao> publicacoes = publicacaoRepository.findAll();
        List<PublicacaoDTO> publicacoesDTO = publicacoes.stream().map(PublicacaoDTO::new).toList();
        return publicacoesDTO;
    }

    public PublicacaoDTO findById(Long id) {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(id);
        if (publicacaoOpt.isPresent()) {
            return new PublicacaoDTO(publicacaoOpt.get());
        }
        throw new NotFoundException();
    }

    public PublicacaoDTO create(Publicacao novaPublicacao) {
        Optional<Usuario> autorOpt = usuarioRepository.findById(novaPublicacao.getAutor().getId());

        if(autorOpt.isEmpty()) {
            throw new NotFoundException();
        }

        novaPublicacao.setDataCriacao(LocalDate.now());

        return new PublicacaoDTO(publicacaoRepository.save(novaPublicacao), autorOpt.get());
    }

    public PublicacaoDTO findAndUpdate(Long id, Publicacao publicacaoEditada) {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(id);

        if (publicacaoOpt.isPresent()) {

            if(publicacaoEditada.getAutor() != null){
                throw new ForeignKeyMustBeNullException("Autor do comentário não pode ser alterado.");
            }

            // Mantém dados que devem permanecer inalterados
            publicacaoEditada.setId(publicacaoOpt.get().getId());
            publicacaoEditada.setAutor(publicacaoOpt.get().getAutor());
            publicacaoEditada.setDataCriacao(publicacaoOpt.get().getDataCriacao());
            publicacaoEditada.setComentarios(publicacaoOpt.get().getComentarios());

            return new PublicacaoDTO(publicacaoRepository.save(publicacaoEditada), publicacaoEditada.getAutor());
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
