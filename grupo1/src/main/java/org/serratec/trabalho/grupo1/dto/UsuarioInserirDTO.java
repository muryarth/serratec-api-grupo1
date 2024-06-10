package org.serratec.trabalho.grupo1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class UsuarioInserirDTO {

	private String nome;

	private String sobrenome;

	private String email;

	private String senha;

	private String confirmaSenha;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
}