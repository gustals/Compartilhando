package com.compartilhando.model.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class CurtidaDTO {
	
	private Long idenficadorUsuario;
	
	public CurtidaDTO(){
		
	}
	public CurtidaDTO(Long idenficadorUsuario) {
		this.idenficadorUsuario = idenficadorUsuario;
	}
	
	public Long getIdenficadorUsuario() {
		return idenficadorUsuario;
	}
	public void setIdenficadorUsuario(Long idenficadorUsuario) {
		this.idenficadorUsuario = idenficadorUsuario;
	}
}
