package com.compartilhando.model;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;


@JsonIdentityInfo(generator = PropertyGenerator.class,  property = "id")
@Entity
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String senha;
	
	@OneToMany
	private List<RelacionamentoUsuarios> seguidores;
	@OneToMany
	private List<RelacionamentoUsuarios> seguindo;
	
	private String pathImagem;
	
	public Usuario() {

	}
	public Usuario(String email, String senha, String nome, String pathImagem) {
		this.email = email;
		this.nome=nome;
		this.senha = senha;
		this.pathImagem=pathImagem;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pathImagem == null) ? 0 : pathImagem.hashCode());
		result = prime * result + ((seguidores == null) ? 0 : seguidores.hashCode());
		result = prime * result + ((seguindo == null) ? 0 : seguindo.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pathImagem == null) {
			if (other.pathImagem != null)
				return false;
		} else if (!pathImagem.equals(other.pathImagem))
			return false;
		if (seguidores == null) {
			if (other.seguidores != null)
				return false;
		} else if (!seguidores.equals(other.seguidores))
			return false;
		if (seguindo == null) {
			if (other.seguindo != null)
				return false;
		} else if (!seguindo.equals(other.seguindo))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	
}
