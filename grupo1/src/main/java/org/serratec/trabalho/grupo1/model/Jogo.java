package org.serratec.trabalho.grupo1.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jogo")
    private Long id;
    // nome,data,empresa
    @Column()
    private String nome;

    @Column(name = "Data_Criacao")
    private LocalDate dataCriacao;

    @Column
    private String empresa;

    public Jogo(Long id, String nome, LocalDate dataCriacao, String empresa) {
        super();
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.empresa = empresa;
    }

    public Jogo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }


}