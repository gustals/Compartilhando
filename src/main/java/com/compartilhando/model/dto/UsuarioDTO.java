package com.compartilhando.model.dto;

public class UsuarioDTO {
	
	private Long id;
	private String email;
	
	public UsuarioDTO() {

	}
	public UsuarioDTO(Long id,String email, String senha) {
		this.id=id;
		this.email = email;

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
}
