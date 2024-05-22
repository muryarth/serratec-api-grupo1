package org.serratec.trabalho.grupo1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
@Entity
@Table(name="relacao")
public class Relacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_relacao")
    @NotBlank(message="A relacao não pode ser vazia ou nula")
    private Long id;

    @Column(name= "date_relacao")
    private Date dataInicioSeguimento;

    public Relacao(Long id, Date dataInicioSeguimento) {
        this.id = id;
        this.dataInicioSeguimento = dataInicioSeguimento;
    }

    public @NotBlank(message = "A relacao não pode ser vazia ou nula") Long getId() {
        return id;
    }

    public void setId(@NotBlank(message = "A relacao não pode ser vazia ou nula") Long id) {
        this.id = id;
    }

    public Date getDataInicioSeguimento() {
        return dataInicioSeguimento;
    }

    public void setDataInicioSeguimento(Date dataInicioSeguimento) {
        this.dataInicioSeguimento = dataInicioSeguimento;
    }

}
