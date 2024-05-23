package org.serratec.trabalho.grupo1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.serratec.trabalho.grupo1.exception.MensagensValidator;

import java.util.Date;
import java.util.Objects;

@Entity
public class Comentario {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long id;

    @NotBlank(message = MensagensValidator.NOT_BLANK)
    @Size(max = 200 ,message = MensagensValidator.INVALID_SIZE)
    @Column(name = "texto", length = 200, nullable = false)
    private String texto;

    @NotNull(message = MensagensValidator.NOT_NULL)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    public Comentario() {
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
