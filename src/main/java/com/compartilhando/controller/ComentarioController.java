package com.compartilhando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compartilhando.model.Comentario;
import com.compartilhando.model.Curtida;
import com.compartilhando.model.dto.ComentarioDTO;
import com.compartilhando.service.ComentarioService;



@RestController
@RequestMapping(value = "/comentario")
public class ComentarioController {
	
	@Autowired
	private ComentarioService comentarioService;
	
	@GetMapping
	public ResponseEntity Listar() {
		try {
			List<Comentario> comentarios = comentarioService.listarTodos();
			return new ResponseEntity(comentarios, HttpStatus.OK);	
		}catch(Exception e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/{id}")
	public ResponseEntity salvarComentarioPost(@PathVariable ("id") Long id, @RequestBody ComentarioDTO comentarioDTO) {
		try {
			Comentario comentario = comentarioService.salvarComentarioPost(id, comentarioDTO);
			return new ResponseEntity(comentario, HttpStatus.OK);	
		}catch(Exception e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
