package com.compartilhando.model.dto;

public class UsuarioCreateDTO {
	
	private String email;
	private String nome;
	private String senha;
	private String pathImagem;
	
	public UsuarioCreateDTO() {

	}
	public UsuarioCreateDTO(String email, String senha, String nome, String pathImagem) {
		this.email = email;
		this.nome=nome;
		this.senha=senha;
		this.pathImagem=pathImagem;

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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPathImagem() {
		return pathImagem;
	}
	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}	
	
	
}
