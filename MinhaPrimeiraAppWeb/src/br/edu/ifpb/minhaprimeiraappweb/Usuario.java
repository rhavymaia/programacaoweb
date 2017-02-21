package br.edu.ifpb.minhaprimeiraappweb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

	@SerializedName("nome")
	@Expose
	private String nome;
	
	@SerializedName("email")
	@Expose
	private String email;
	
	@SerializedName("senha")
	@Expose
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}