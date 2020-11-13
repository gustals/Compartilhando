package com.compartilhando.model;

import javax.persistence.*;

@Entity
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String textoPost;
	@ManyToOne
	private Usuario usuario;
	
	public Post() {

	}

	public Post(String textoPost, Usuario usuario) {
		this.textoPost = textoPost;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
