package com.compartilhando.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Curtida {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Usuario idenficadorUsuario;
	
	public Curtida(){
		
	}
	public Curtida(Usuario idenficadorUsuario) {
		this.idenficadorUsuario = idenficadorUsuario;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getIdenficadorUsuario() {
		return idenficadorUsuario;
	}
	public void setIdenficadorUsuario(Usuario idenficadorUsuario) {
		this.idenficadorUsuario = idenficadorUsuario;
	}
}
