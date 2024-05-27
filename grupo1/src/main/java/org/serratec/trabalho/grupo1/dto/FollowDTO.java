package org.serratec.trabalho.grupo1.dto;

public class FollowDTO {
    private Long idSeguidor;
    private String nomeSeguidor;
    private Long idSeguido;
    private String nomeSeguido;

    public FollowDTO() {
    }

    public FollowDTO(Long idSeguidor, String nomeSeguidor, Long idSeguido, String nomeSeguido) {
        this.idSeguidor = idSeguidor;
        this.nomeSeguidor = nomeSeguidor;
        this.idSeguido = idSeguido;
        this.nomeSeguido = nomeSeguido;
    }

    public FollowDTO(Object[] array) {
        this.idSeguidor = (Long) array[0];
        this.nomeSeguidor = (String) array[1];
        this.idSeguido = (Long) array[2];
        this.nomeSeguido = (String) array[3];
    }

    public Long getIdSeguidor() {
        return idSeguidor;
    }

    public void setIdSeguidor(Long idSeguidor) {
        this.idSeguidor = idSeguidor;
    }

    public String getNomeSeguidor() {
        return nomeSeguidor;
    }

    public void setNomeSeguidor(String nomeSeguidor) {
        this.nomeSeguidor = nomeSeguidor;
    }

    public Long getIdSeguido() {
        return idSeguido;
    }

    public void setIdSeguido(Long idSeguido) {
        this.idSeguido = idSeguido;
    }

    public String getNomeSeguido() {
        return nomeSeguido;
    }

    public void setNomeSeguido(String nomeSeguido) {
        this.nomeSeguido = nomeSeguido;
    }
}
