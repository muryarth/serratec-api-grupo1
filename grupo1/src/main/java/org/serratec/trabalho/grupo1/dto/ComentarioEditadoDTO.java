package org.serratec.trabalho.grupo1.dto;

public class ComentarioEditadoDTO {

    private String texto;

    public ComentarioEditadoDTO() {
    }

    public ComentarioEditadoDTO(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
