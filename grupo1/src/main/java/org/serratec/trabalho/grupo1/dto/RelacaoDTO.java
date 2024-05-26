package org.serratec.trabalho.grupo1.dto;

import org.serratec.trabalho.grupo1.model.Relacao;

import java.time.LocalDate;

public class RelacaoDTO {

    private String seguido;
    private String seguidoEmail;
    private String seguidor;
    private LocalDate dataFollow;

    public RelacaoDTO(Relacao relacao) {
        this.seguido = relacao.getId().getSeguido().getNome();
        this.seguidoEmail = relacao.getId().getSeguido().getEmail();
        this.seguidor = relacao.getId().getSeguidor().getNome();
        this.dataFollow = relacao.getDataRealizacao();
    }

    public String getSeguido() {
        return seguido;
    }

    public void setSeguido(String seguido) {
        this.seguido = seguido;
    }

    public String getSeguidoEmail() {
        return seguidoEmail;
    }

    public void setSeguidoEmail(String seguidoEmail) {
        this.seguidoEmail = seguidoEmail;
    }

    public String getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(String seguidor) {
        this.seguidor = seguidor;
    }

    public LocalDate getDataFollow() {
        return dataFollow;
    }

    public void setDataFollow(LocalDate dataFollow) {
        this.dataFollow = dataFollow;
    }
}
