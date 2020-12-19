package com.compartilhando.model.dto;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


public class ComentarioDTO {

	private Long idenficadorUsuario;
	private String descricaoComentario;
	
	public ComentarioDTO() {

	}
	
	public ComentarioDTO(Long user, String descricaoComentario) {
		this.idenficadorUsuario = user;
		this.descricaoComentario = descricaoComentario;
	}
	
	public Long getIdenficadorUsuario() {
		return idenficadorUsuario;
	}
	public void setIdenficadorUsuario(Long user) {
		this.idenficadorUsuario = user;
	}
	public String getDescricaoComentario() {
		return descricaoComentario;
	}
	public void setDescricaoComentario(String descricaoComentario) {
		this.descricaoComentario = descricaoComentario;
	}
}
