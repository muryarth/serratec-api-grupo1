package org.serratec.trabalho.grupo1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.serratec.trabalho.grupo1.exception.MensagensValidator;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_usuario")
    @NotBlank(message = MensagensValidator.NOT_BLANK)
    private long id_usuario;

    @Column(name= "nome_usuario")
    @Size(max = 40, message = MensagensValidator.INVALID_SIZE)
    @NotBlank(message = MensagensValidator.NOT_BLANK)
    private String nome;

    @Column(name= "sobrenome_usuario")
    @Size(max = 40, message= MensagensValidator.INVALID_SIZE)
    @NotBlank(message = MensagensValidator.NOT_BLANK)
    private String sobrenome;

    @Column(name= "email_usuario")
    @Size(max = 40, message= MensagensValidator.INVALID_SIZE)
    @NotBlank(message = MensagensValidator.NOT_BLANK)
    private String email;

    @Column(name= "senha_usuario")
    @Size(max = 40, message= MensagensValidator.INVALID_SIZE)
    @NotBlank(message = MensagensValidator.NOT_BLANK)
    private String senha;

    @Column(name= "nascimento_usuario")
    private Date dataNascimento;

    @NotBlank(message = MensagensValidator.NOT_BLANK)
    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(@NotBlank(message = MensagensValidator.NOT_BLANK) long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public @Size(max = 40, message = MensagensValidator.INVALID_SIZE) @NotBlank(message = MensagensValidator.NOT_BLANK) String getNome() {
        return nome;
    }

    public void setNome(@Size(max = 40, message = MensagensValidator.INVALID_SIZE) @NotBlank(message = MensagensValidator.NOT_BLANK) String nome) {
        this.nome = nome;
    }

    public @Size(max = 40, message = MensagensValidator.INVALID_SIZE) @NotBlank(message = MensagensValidator.NOT_BLANK) String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(@Size(max = 40, message = MensagensValidator.INVALID_SIZE) @NotBlank(message = MensagensValidator.NOT_BLANK) String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public @Size(max = 40, message = MensagensValidator.INVALID_SIZE) @NotBlank(message = MensagensValidator.NOT_BLANK) String getEmail() {
        return email;
    }

    public void setEmail(@Size(max = 40, message = MensagensValidator.INVALID_SIZE) @NotBlank(message = MensagensValidator.NOT_BLANK) String email) {
        this.email = email;
    }

    public @Size(max = 40, message = MensagensValidator.INVALID_SIZE) @NotBlank(message = MensagensValidator.NOT_BLANK) String getSenha() {
        return senha;
    }

    public void setSenha(@Size(max = 40, message = MensagensValidator.INVALID_SIZE) @NotBlank(message = MensagensValidator.NOT_BLANK) String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id_usuario == usuario.id_usuario;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_usuario);
    }
}
