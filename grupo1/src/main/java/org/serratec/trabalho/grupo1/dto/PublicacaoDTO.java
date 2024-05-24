package org.serratec.trabalho.grupo1.dto;

import org.serratec.trabalho.grupo1.model.Publicacao;

import java.time.LocalDate;

public class PublicacaoDTO {

    private Long id;
    private String conteudo;
    private LocalDate dataCriacao;

    public PublicacaoDTO() {
    }

    public PublicacaoDTO(Publicacao publicacao) {
        this.id = publicacao.getId();
        this.conteudo = publicacao.getConteudo();
        this.dataCriacao = publicacao.getDataCriacao();
    }

    public PublicacaoDTO(Long id, String conteudo, LocalDate dataCriacao) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
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
}
