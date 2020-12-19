package com.compartilhando.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

//@JsonIgnoreProperties(ignoreUnknown=true, value= {"seguidores", "seguindo"})
@JsonIdentityInfo(generator = PropertyGenerator.class,  property = "id")
@Entity
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String senha;

	@OneToMany
	private List<RelacionamentoUsuarios> seguidores;
	@OneToMany
	private List<RelacionamentoUsuarios> seguindo;
	
	private String pathImagem;
	
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
	public List<RelacionamentoUsuarios> getSeguidores() {
		return seguidores;
	}
	public void setSeguidores(List<RelacionamentoUsuarios> seguidores) {
		this.seguidores = seguidores;
	}
	public void addSeguidores(RelacionamentoUsuarios user) {
		this.seguidores.add(user);
	}
	public List<RelacionamentoUsuarios> getSeguindo() {
		return seguindo;
	}
	public void setSeguindo(List<RelacionamentoUsuarios> seguindo) {
		this.seguindo = seguindo;
	}
	public void addSeguindo(RelacionamentoUsuarios user) {
		this.seguindo.add(user);
	}
	public String getPathImagem() {
		return pathImagem;
	}
	public void setPathImagem(String pathImagem) {
		this.pathImagem = pathImagem;
	}
	
}
