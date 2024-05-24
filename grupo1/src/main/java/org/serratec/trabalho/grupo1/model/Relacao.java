package org.serratec.trabalho.grupo1.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.serratec.trabalho.grupo1.dto.UsuarioDTO;

@Entity
@Table(name = "relacao")
public class Relacao {

    @EmbeddedId
    private RelacaoPK id = new RelacaoPK();

    @Column(name = "data_realizacao")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataRealizacao;

    public Relacao() {
    }

    public Relacao(RelacaoPK id, LocalDate dataRealizacao) {
        this.id = id;
        this.dataRealizacao = dataRealizacao;
    }

    public RelacaoPK getId() {
        return id;
    }

    public void setId(RelacaoPK id) {
        this.id = id;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
}