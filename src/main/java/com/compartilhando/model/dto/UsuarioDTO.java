package com.compartilhando.model.dto;

public class UsuarioDTO {
	
	private Long id;
	private String email;
	private String nome;
	private String senha;
	
	public UsuarioDTO() {

	}
//	public UsuarioDTO(Long id,String email, String senha, String nome) {
//		this.id=id;
//		this.email = email;
//		this.nome=nome;
//		this.senha=senha;
//
//	}
//	
	public UsuarioDTO(String email, String senha, String nome) {
		this.email = email;
		this.nome=nome;
		this.senha=senha;

	}
	public UsuarioDTO(Long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
}
