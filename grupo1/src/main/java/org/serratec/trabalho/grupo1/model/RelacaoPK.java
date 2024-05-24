package org.serratec.trabalho.grupo1.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class RelacaoPK {

    @ManyToOne
    @JoinColumn(name = "seguido_id", referencedColumnName = "id_usuario")
    private Usuario seguido;

    @ManyToOne
    @JoinColumn(name = "seguidor_id", referencedColumnName = "id_usuario")
    private Usuario seguidor;

    public Usuario getSeguido() {
        return seguido;
    }

    public void setSeguido(Usuario seguido) {
        this.seguido = seguido;
    }

    public Usuario getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(Usuario seguidor) {
        this.seguidor = seguidor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelacaoPK relacaoPK = (RelacaoPK) o;
        return Objects.equals(seguido, relacaoPK.seguido) && Objects.equals(seguidor, relacaoPK.seguidor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seguido, seguidor);
    }
}