package org.serratec.trabalho.grupo1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.serratec.trabalho.grupo1.exception.MensagensValidator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
@Table(name="usuario")
public class Usuario implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_usuario")
    private long id;

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

    @Column(name= "senha_usuario", length = 80)
    @Size(max = 80, message= MensagensValidator.INVALID_SIZE)
    @NotBlank(message = MensagensValidator.NOT_BLANK)
    private String senha;

    @Column(name= "data_nascimento_usuario")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    
    @OneToMany(mappedBy = "id.seguidor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Relacao> seguindo = new HashSet<>();

    @OneToMany(mappedBy = "id.seguido", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Relacao> seguidores = new HashSet<>();
    
    @OneToMany(mappedBy = "id.usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();
    
    
    @Column(name= "tipoPerfil")
    @Size(max = 40, message= MensagensValidator.INVALID_SIZE)
    private String tipoPerfil;

    public long getId() {
		return id;
	}

	public void setId(long id_usuario) {
		this.id = id_usuario;
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
    

	public Set<UsuarioPerfil> getUsuarioPerfis() {
		return usuarioPerfis;
	}

	public void setUsuarioPerfis(Set<UsuarioPerfil> usuarioPerfis) {
		this.usuarioPerfis = usuarioPerfis;
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(UsuarioPerfil usuarioPerfil: getUsuarioPerfis()) {
			authorities.add(new SimpleGrantedAuthority(usuarioPerfil.getId().getPerfil().getNome()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
