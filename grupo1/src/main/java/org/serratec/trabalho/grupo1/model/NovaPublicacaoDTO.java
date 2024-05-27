package org.serratec.trabalho.grupo1.model;

public class NovaPublicacaoDTO {

    private String conteudo;
    private Usuario autor;

    public NovaPublicacaoDTO() {
    }

    public NovaPublicacaoDTO(String conteudo, Usuario autor) {
        this.conteudo = conteudo;
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}
