package org.serratec.trabalho.grupo1.dto;

import org.serratec.trabalho.grupo1.model.Publicacao;
import org.serratec.trabalho.grupo1.model.Usuario;

import java.time.LocalDate;

public class PublicacaoDTO {

    private Long id;
    private String conteudo;
    private LocalDate dataCriacao;
    private String autor;

    public PublicacaoDTO() {
        super();
    }

    public PublicacaoDTO(Publicacao publicacao) {
        super();
        this.id = publicacao.getId();
        this.conteudo = publicacao.getConteudo();
        this.dataCriacao = publicacao.getDataCriacao();
        this.autor = String.format("%s %s", publicacao.getAutor().getNome(), publicacao.getAutor().getSobrenome());
    }

    public PublicacaoDTO(Publicacao publicacao, Usuario autor) {
        super();
        this.id = publicacao.getId();
        this.conteudo = publicacao.getConteudo();
        this.dataCriacao = publicacao.getDataCriacao();
        this.autor = String.format("%s %s", autor.getNome(), autor.getSobrenome());
    }

    public PublicacaoDTO(Long id, String conteudo, LocalDate dataCriacao, String autor) {
        super();
        this.id = id;
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
