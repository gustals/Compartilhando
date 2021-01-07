package com.compartilhando.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class PostUpdateDTO {
	
	private Long id;
	private String textoPost;
	private String pathImagem;
	
	public PostUpdateDTO() {

	}
	
	public PostUpdateDTO(Long id, String textoPost, String pathImagem) {
		this.id=id;
		this.textoPost = textoPost;
		this.pathImagem=pathImagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
