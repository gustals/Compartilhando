package com.compartilhando.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class PostCreateDTO {
	
	private String textoPost;
	private Long usuarioIdentificador;
	private String pathImagem;
	
	public PostCreateDTO() {

	}
	
	public PostCreateDTO(String textoPost, Long usuarioIdentificador, String pathImagem) {
		this.textoPost = textoPost;
		this.usuarioIdentificador = usuarioIdentificador;
		this.pathImagem=pathImagem;
	}
	
	

	public String getPathImagem() {
		return pathImagem;
	}

	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
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
