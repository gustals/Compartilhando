package com.compartilhando.model.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class CurtidaDTO {
	
	private Long id;
	private String idenficadorUsuario;
	
	public CurtidaDTO(){
		
	}
	public CurtidaDTO(Long id, String idenficadorUsuario) {
		this.id=id;
		this.idenficadorUsuario = idenficadorUsuario;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdenficadorUsuario() {
		return idenficadorUsuario;
	}
	public void setIdenficadorUsuario(String idenficadorUsuario) {
		this.idenficadorUsuario = idenficadorUsuario;
	}
}
