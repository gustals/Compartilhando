package com.compartilhando.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Comentario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Usuario usuario;
	private String descricaoComentario;
	private LocalDateTime dateHoraComentario;//ajustar para pegar do front, quando tiver front
	@OneToMany
	private List<Curtida> curtidas;
	
	
	public Comentario() {

	}
	
	public Comentario(Usuario usuario, String descricaoComentario) {
		this.usuario = usuario;
		this.descricaoComentario = descricaoComentario;
		this.dateHoraComentario=LocalDateTime.now();
		this.curtidas=null;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricaoComentario() {
		return descricaoComentario;
	}
	public void setDescricaoComentario(String descricaoComentario) {
		this.descricaoComentario = descricaoComentario;
	}
	public List<Curtida> getCurtidas() {
		return curtidas;
	}
	public void setCurtidas(List<Curtida> curtidas) {
		this.curtidas = curtidas;
	}

	public Usuario getUser() {
		return usuario;
	}

	public void setUser(Usuario user) {
		this.usuario = usuario;
	}

	public LocalDateTime getDateHoraComentario() {
		return dateHoraComentario;
	}

	public void setDateHoraComentario(LocalDateTime dateHoraComentario) {
		this.dateHoraComentario = dateHoraComentario;
	}	
}
