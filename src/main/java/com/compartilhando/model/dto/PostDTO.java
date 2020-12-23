package com.compartilhando.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class PostDTO {
	
	private Long id;
	private String textoPost;
	private Long usuarioIdentificador;
	
	public PostDTO() {

	}
	
	public PostDTO(String textoPost, Long usuarioIdentificador) {
		this.textoPost = textoPost;
		this.usuarioIdentificador = usuarioIdentificador;
	}
	
	public PostDTO(Long id,String textoPost, Long usuarioIdentificador) {
		this.id=id;
		this.textoPost = textoPost;
		this.usuarioIdentificador = usuarioIdentificador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextoPost() {
		return textoPost;
	}

	public void setTextoPost(String textoPost) {
		this.textoPost = textoPost;
	}

	public Long getUsuario() {
		return usuarioIdentificador;
	}

	public void setUsuario(Long usuarioIdentificador) {
		this.usuarioIdentificador = usuarioIdentificador;
	}
}
