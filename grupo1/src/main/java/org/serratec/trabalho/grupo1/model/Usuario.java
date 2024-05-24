package org.serratec.trabalho.grupo1.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.serratec.trabalho.grupo1.exception.MensagensValidator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_usuario")
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
    
    @OneToMany(mappedBy = "id.seguidor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Relacao> seguindo = new HashSet<>();

    @OneToMany(mappedBy = "id.seguido", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Relacao> seguidores = new HashSet<>();

    public long getId() {
		return id_usuario;
	}

	public void setId(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Set<Relacao> getSeguindo() {
        return seguindo;
    }

    public void setSeguindo(Set<Relacao> seguindo) {
        this.seguindo = seguindo;
    }

    public Set<Relacao> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Set<Relacao> seguidores) {
        this.seguidores = seguidores;
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
