package com.compartilhando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compartilhando.model.Comentario;
import com.compartilhando.model.Post;
import com.compartilhando.repository.ComentarioRepository;


@RestController
@RequestMapping(value = "/Comentario")
public class ComentarioController {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@GetMapping
	public List<Comentario> Listar() {
		return (List<Comentario>) comentarioRepository.findAll();
	}
	
	@PostMapping
	public Comentario salvarComentario(@RequestBody Comentario comentario) {
		return comentarioRepository.save(comentario);
	}

}
