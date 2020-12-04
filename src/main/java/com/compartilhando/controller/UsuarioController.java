package com.compartilhando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compartilhando.model.Usuario;
import com.compartilhando.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
		
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/")
	public List<Usuario> Listar(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable("id") Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	@PostMapping
	public Usuario cadastrarUsuario(@RequestBody Usuario novoUsuario) {
		return usuarioRepository.save(novoUsuario);
	}
	
}
