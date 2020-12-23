package com.compartilhando.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.compartilhando.enums.TipoImagem;
import com.compartilhando.model.Postagem;
import com.compartilhando.model.dto.PostDTO;
import com.compartilhando.repository.PostRepository;
import com.compartilhando.repository.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostagemService {
	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ImagemService imagemService;
	
	
	@GetMapping
	public List<Postagem> listarTodos() {
		return (List<Postagem>) postRepository.findAll();
	}
	
	public Postagem buscarPorId(Long id) {
		return postRepository.findById(id).get();
	}
	
	
	public Postagem salvarPostagem( MultipartFile file, PostDTO postNovo) throws JsonProcessingException  {
		
		Postagem post = new Postagem(postNovo.getTextoPost(), usuarioRepository.findById(postNovo.getUsuario()).get());
		
		post.setDateHoraPost(LocalDateTime.now());
		postRepository.save(post);
		
		String pathImagem = imagemService.salvarFoto(TipoImagem.POST, post.getId(), file);
		post.setPathImagem(pathImagem);
		
		return postRepository.save(post);
		
	}
	
	public Postagem editarPostagem( MultipartFile file, PostDTO postNovo) throws JsonProcessingException  {
		
		Postagem post = postRepository.findById(postNovo.getId()).get();
		post.setTextoPost(postNovo.getTextoPost());
		
		if(!file.isEmpty()) {
			String pathImagem = imagemService.salvarFoto(TipoImagem.POST, post.getId(), file);
			post.setPathImagem(pathImagem);
		}

		return postRepository.save(post);
		
	}
	
}
