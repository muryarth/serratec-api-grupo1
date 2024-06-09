package org.serratec.trabalho.grupo1.model;

public class NovoComentarioDTO {

    private String texto;
    private Long idPublicacao;
    private Long idAutor;

    public NovoComentarioDTO() {
    }

    public NovoComentarioDTO(String texto, Long idPublicacao, Long idAutor) {
        this.texto = texto;
        this.idPublicacao = idPublicacao;
        this.idAutor = idAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Long idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }
}
