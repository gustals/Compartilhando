package com.compartilhando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compartilhando.model.Comentario;
import com.compartilhando.model.Curtida;
import com.compartilhando.model.Post;
import com.compartilhando.model.Usuario;
import com.compartilhando.model.dto.CurtidaDTO;
import com.compartilhando.repository.ComentarioRepository;
import com.compartilhando.repository.CurtidaRepository;
import com.compartilhando.repository.PostRepository;
import com.compartilhando.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/curtir")
public class CurtidaController {
	
	@Autowired
	private CurtidaRepository curtidaRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping
	public List<Curtida> Listar() {
		return (List<Curtida>) curtidaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Curtida buscarPorId(@PathVariable("id") Long id) {
		return curtidaRepository.findById(id).get();
	}
	
	@PostMapping("/comentario/{id}")
	public Curtida salvarCurtidaComentario(@PathVariable ("id") Long id, @RequestBody CurtidaDTO curtidaDTO) {
		Comentario comentario = comentarioRepository.findById(id).get();
		Usuario usuario = usuarioRepository.findById(curtidaDTO.getIdenficadorUsuario()).get();
		Curtida curtida= new Curtida(usuario);
		curtidaRepository.save(curtida);
		comentario.addCurtidas(curtida);
		comentarioRepository.save(comentario);
		
		return curtida;
	}
	
	@PostMapping("/post/{id}")
	public Curtida salvarCurtidaPost(@PathVariable ("id") Long id, @RequestBody CurtidaDTO curtidaDTO) {
		Post post = postRepository.findById(id).get();
		Usuario usuario = usuarioRepository.findById(curtidaDTO.getIdenficadorUsuario()).get();
		Curtida curtida= new Curtida(usuario);
		curtidaRepository.save(curtida);
		post.addCurtidas(curtida);
		postRepository.save(post);
		
		return curtida;
	}

}
