package com.compartilhando.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compartilhando.model.Comentario;
import com.compartilhando.model.Post;
import com.compartilhando.model.Usuario;
import com.compartilhando.model.dto.ComentarioDTO;
import com.compartilhando.repository.ComentarioRepository;
import com.compartilhando.repository.PostRepository;
import com.compartilhando.repository.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(value = "/comentario")
public class ComentarioController {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Comentario> Listar() {
		return (List<Comentario>) comentarioRepository.findAll();
	}
	
	@PostMapping("/{id}")
	public Comentario salvarComentario(@PathVariable ("id") Long id,@RequestBody ComentarioDTO comentarioDTO) {
		Usuario usuario = usuarioRepository.findById(comentarioDTO.getIdenficadorUsuario()).get();
		Comentario comentario = new Comentario(usuario, comentarioDTO.getDescricaoComentario());
		
		comentario.setDateHoraComentario(LocalDateTime.now());
		comentarioRepository.save(comentario);
		Post post= postRepository.findById(id).get();
		post.addComentarios(comentario);
		postRepository.save(post);
		return comentario;
	}

}
