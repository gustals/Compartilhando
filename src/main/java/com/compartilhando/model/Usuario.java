package com.compartilhando.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String senha;
	@OneToMany
	private List<Usuario> seguidores;
	@OneToMany
	private List<Usuario> seguindo;
	
	public Usuario() {

	}
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
		this.seguidores=null;
		this.seguindo=null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Usuario> getSeguidores() {
		return seguidores;
	}
	public void setSeguidores(List<Usuario> seguidores) {
		this.seguidores = seguidores;
	}
	public List<Usuario> getSeguindo() {
		return seguindo;
	}
	public void setSeguindo(List<Usuario> seguindo) {
		this.seguindo = seguindo;
	}
	
}
