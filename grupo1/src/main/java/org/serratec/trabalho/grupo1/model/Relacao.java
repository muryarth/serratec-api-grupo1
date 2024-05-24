package org.serratec.trabalho.grupo1.model;

import java.util.Objects;

import org.serratec.trabalho.grupo1.dto.UsuarioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "relacao")
public class Relacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seguidor_id", referencedColumnName = "id_usuario")
    private UsuarioDTO seguidor;

    @ManyToOne
    @JoinColumn(name = "seguido_id", referencedColumnName = "id_usuario")
    private UsuarioDTO seguido;

    public Relacao() {}

    public Relacao(UsuarioDTO seguidor, UsuarioDTO seguido) {
        this.seguidor = seguidor;
        this.seguido = seguido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioDTO getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(UsuarioDTO seguidor) {
        this.seguidor = seguidor;
    }

    public UsuarioDTO getSeguido() {
        return seguido;
    }

    public void setSeguido(UsuarioDTO seguido) {
        this.seguido = seguido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relacao relacao = (Relacao) o;
        return Objects.equals(id, relacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
