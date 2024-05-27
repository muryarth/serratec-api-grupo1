package org.serratec.trabalho.grupo1.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.serratec.trabalho.grupo1.exception.MensagensValidator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotBlank(message = MensagensValidator.NOT_BLANK)
    @Size(max = 255, message = MensagensValidator.INVALID_MAX_SIZE)
    @Column(name = "conteudo", nullable = false, length = 255)
    private String conteudo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @ManyToOne(fetch = FetchType.EAGER)
    // @JsonBackReference
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario autor;

    @OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Comentario> comentarios;

    public Publicacao() {
        super();
    }

    public Publicacao(NovaPublicacaoDTO publi) {
        this.conteudo = publi.getConteudo();
        this.autor = publi.getAutor();
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

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
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
