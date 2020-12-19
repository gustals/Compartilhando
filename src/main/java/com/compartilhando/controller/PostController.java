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
import org.springframework.web.multipart.MultipartFile;

import com.compartilhando.classificador.TipoImagem;
import com.compartilhando.model.Post;
import com.compartilhando.model.Usuario;
import com.compartilhando.repository.PostRepository;
import com.compartilhando.service.ImagemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/post")
public class PostController {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ImagemService imagemService;
	
	
	@GetMapping
	public List<Post> Listar() {
		return (List<Post>) postRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Post buscarPorId(@PathVariable("id") Long id) {
		return postRepository.findById(id).get();
	}
	
	@PostMapping
	public Post salvarPost(@RequestParam(value = "file", required = false) MultipartFile file,@RequestParam String postString) throws JsonProcessingException  {
		ObjectMapper mapper = new ObjectMapper();
		Post post = mapper.readValue(postString.toString(), Post.class);
		
		post.setDateHoraPost(LocalDateTime.now());
		postRepository.save(post);
		
		String pathImagem = imagemService.salvarFoto(TipoImagem.POST, post.getId(), file);
		post.setPathImagem(pathImagem);
		
		return postRepository.save(post);
		
	}
}
