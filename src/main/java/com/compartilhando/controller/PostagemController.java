package com.compartilhando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.compartilhando.exception.RegraDeNegocioException;
import com.compartilhando.model.Postagem;
import com.compartilhando.model.Usuario;
import com.compartilhando.model.dto.PostCreateDTO;
import com.compartilhando.model.dto.PostUpdateDTO;
import com.compartilhando.service.PostagemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/post")
public class PostagemController {
	
	@Autowired
	private PostagemService postagemService;
	
	
	@GetMapping
	public ResponseEntity listarTodos() {
		try {
			List<Postagem> postagens = postagemService.listarTodos();
			return new ResponseEntity(postagens, HttpStatus.OK);	
		}catch(Exception e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
		try {
			Postagem postagem = postagemService.buscarPorId(id);
			return new ResponseEntity(postagem, HttpStatus.OK);	
		}catch(Exception e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity salvarPostagem(@RequestBody PostCreateDTO novoPost) throws JsonProcessingException  {
	
		try {
			Postagem postagem = postagemService.salvarPostagem(novoPost);	
			return new ResponseEntity(postagem, HttpStatus.CREATED);	
		}catch(RegraDeNegocioException e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
			
	}
	
	@PutMapping("/editar")
	public ResponseEntity editarPostagem(@RequestBody PostUpdateDTO postEditado) throws JsonProcessingException  {
		
		try {
			Postagem postagem = postagemService.editarPostagem(postEditado);
			return new ResponseEntity(postagem, HttpStatus.OK);		
		}catch(Exception e){			
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
}
