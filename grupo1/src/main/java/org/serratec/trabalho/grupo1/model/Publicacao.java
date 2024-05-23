package org.serratec.trabalho.grupo1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.serratec.trabalho.grupo1.exception.MensagensValidator;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotBlank(message = MensagensValidator.NOT_BLANK)
    @Size(message = MensagensValidator.INVALID_MAX_SIZE)
    @Column(name = "conteudo", nullable = false, length = 255)
    private String conteudo;

    @NotNull(message = MensagensValidator.NOT_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "data_criacao", nullable = false)
    private LocalDate dataCriacao;

    public Publicacao() {
        super();
    }

    public Publicacao(Long id, String conteudo, LocalDate dataCriacao) {
        super();
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

    public @NotBlank(message = MensagensValidator.NOT_BLANK) @Size(message = MensagensValidator.INVALID_SIZE) String getConteudo() {
        return conteudo;
    }

    public void setConteudo(@NotBlank(message = MensagensValidator.NOT_BLANK) @Size(message = MensagensValidator.INVALID_SIZE) String conteudo) {
        this.conteudo = conteudo;
    }

    public @NotNull(message = MensagensValidator.NOT_NULL) LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(@NotNull(message = MensagensValidator.NOT_NULL) LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacao that = (Publicacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
