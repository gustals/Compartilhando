package com.compartilhando.model;

import java.time.*;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@Entity
public class Postagem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String textoPost;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dateHoraPost;//ajustar para pegar do front, quando tiver front
	@OneToMany
	private List<Comentario> comentarios;
	@ManyToOne
	private Usuario usuario;
	@OneToMany
	private List<Curtida> curtidas;
	private String pathImagem;
	
	public Postagem() {

	}

	public Postagem(String textoPost, Usuario usuario) {
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
	
	public LocalDateTime getDateHoraPost() {
		return dateHoraPost;
	}

	public void setDateHoraPost(LocalDateTime dateHoraPost) {
		this.dateHoraPost = dateHoraPost;
	}

	public String getPathImagem() {
		return pathImagem;
	}

	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void addComentarios(Comentario comentarios) {
		this.comentarios.add(comentarios);
	}

	public List<Curtida> getCurtidas() {
		return curtidas;
	}

	public void addCurtidas(Curtida curtida) {
		this.curtidas.add(curtida);
	}

	
	
	
}
