package org.serratec.trabalho.grupo1.dto;

import org.serratec.trabalho.grupo1.model.Comentario;

import java.time.LocalDate;

public class ComentarioDTO {

    private Long id;
    private String texto;
    private LocalDate dataCriacao;
    private Long autorId;

    public ComentarioDTO(Comentario comentario) {
        this.id = comentario.getId();
        this.texto = comentario.getTexto();
        this.dataCriacao = comentario.getDataCriacao();
        this.autorId = comentario.getAutor().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
}
