package com.compartilhando.model.dto;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


public class ComentarioDTO {

	private String user;
	private String descricaoComentario;
	
	public ComentarioDTO() {

	}
	
	public ComentarioDTO(String user, String descricaoComentario) {
		this.user = user;
		this.descricaoComentario = descricaoComentario;
	}
	
	public String getIdenficadorUsuario() {
		return user;
	}
	public void setIdenficadorUsuario(String user) {
		this.user = user;
	}
	public String getDescricaoComentario() {
		return descricaoComentario;
	}
	public void setDescricaoComentario(String descricaoComentario) {
		this.descricaoComentario = descricaoComentario;
	}
}
