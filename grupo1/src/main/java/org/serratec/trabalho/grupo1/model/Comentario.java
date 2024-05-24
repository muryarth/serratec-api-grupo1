package org.serratec.trabalho.grupo1.model;

import java.time.LocalDate;
import java.util.Objects;

import org.serratec.trabalho.grupo1.exception.MensagensValidator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
    @Column(name = "data_criacao", nullable = false)
    private LocalDate dataCriacao;


    //Construtor padrao para JPA.
    public Comentario() {
        // Construtor vazio
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

    public @NotNull(message = "O campo não pode ser vazio ou nulo.") LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(@NotNull(message = "O campo não pode ser vazio ou nulo.") LocalDate dataCriacao) {
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
