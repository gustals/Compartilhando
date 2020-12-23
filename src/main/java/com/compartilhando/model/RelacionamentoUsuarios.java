package com.compartilhando.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@JsonIdentityInfo(generator = PropertyGenerator.class,  property = "id")
@Entity
public class RelacionamentoUsuarios {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long usuarioId;
	
	public RelacionamentoUsuarios() {

	}
	public RelacionamentoUsuarios(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getusuarioId() {
		return usuarioId;
	}

	public void setusuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

}
