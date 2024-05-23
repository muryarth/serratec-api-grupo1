package org.serratec.trabalho.grupo1.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.serratec.trabalho.grupo1.model.Usuario;

public class UsuarioDTO {
	
	 private long id_usuario;
	 
	 private String nome;
	 
	 private String sobrenome;
	 
	 private String email;
	 
	 private Date dataNascimento;
	 
	 private Set<Usuario> usuarios;

	public UsuarioDTO() {
	}

	public UsuarioDTO(long id_usuario, String nome, String sobrenome, String email, Date dataNascimento) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.usuarios = new HashSet<>();
	}
	
	public UsuarioDTO(Usuario usuario) {
		this.id_usuario = usuario.getId_usuario();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.email = usuario.getEmail();
		this.dataNascimento = usuario.getDataNascimento();
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
