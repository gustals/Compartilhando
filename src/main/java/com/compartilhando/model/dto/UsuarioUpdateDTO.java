package com.compartilhando.model.dto;

public class UsuarioUpdateDTO {
	
	private Long id;
	private String nome;
	private String senha;
	private String pathImagem;
	
	public UsuarioUpdateDTO() {

	}
	public UsuarioUpdateDTO(Long id, String senha, String nome, String pathImagem) {
		this.id=id;
		this.nome=nome;
		this.senha=senha;
		this.pathImagem=pathImagem;

	}
	
	public UsuarioUpdateDTO(Long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
