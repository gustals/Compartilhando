package com.compartilhando.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.compartilhando.enums.TipoImagem;
import com.compartilhando.exception.RegraDeNegocioException;
import com.compartilhando.model.Postagem;
import com.compartilhando.model.dto.PostCreateDTO;
import com.compartilhando.model.dto.PostUpdateDTO;
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
	@Value("${compartilhando.imagens.fotos.postPadrao}")
	private String fotoPadraoPost;
	
	
	public List<Postagem> listarTodos() {
		return (List<Postagem>) postRepository.findAll();
	}
	
	public Postagem buscarPorId(Long id) {
		if(postRepository.findById(id).isPresent())
			return postRepository.findById(id).get();
		else
			throw new RegraDeNegocioException("Usuario não existe");
		
	}
	
	
	public Postagem salvarPostagem(PostCreateDTO postNovo) throws JsonProcessingException  {
		
		if(!usuarioRepository.findById(postNovo.getUsuario()).isPresent()) {
			throw new RegraDeNegocioException("Usuario não existe");
		}
		
		Postagem post = new Postagem(postNovo.getTextoPost(), usuarioRepository.findById(postNovo.getUsuario()).get(), postNovo.getPathImagem());
		post.setDateHoraPost(LocalDateTime.now());
		
		if(post.getPathImagem().equals("")) 
			post.setPathImagem(fotoPadraoPost);
				
		return postRepository.save(post);
	}
	
	public Postagem editarPostagem(PostUpdateDTO postNovo) throws JsonProcessingException  {	
		
		if(!postRepository.findById(postNovo.getId()).isPresent()) {
			throw new RegraDeNegocioException("Postagem não existe");
		}
		
		Postagem post = postRepository.findById(postNovo.getId()).get();
		post.setTextoPost(postNovo.getTextoPost());
		post.setPathImagem(postNovo.getPathImagem());

		return postRepository.save(post);		
	}
	
}
