package org.serratec.trabalho.grupo1.dto;

public class UsuarioInserirDTO {

	private String nome;

	private String sobrenome;

	private String email;

	private String senha;

	private String confirmaSenha;

	//	private Set<Perfil> perfis;

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	/* public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	} */
}