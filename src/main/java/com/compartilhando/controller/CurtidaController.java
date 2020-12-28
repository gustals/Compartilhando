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

import com.compartilhando.model.Curtida;
import com.compartilhando.model.Usuario;
import com.compartilhando.model.dto.CurtidaDTO;
import com.compartilhando.service.CurtidaService;

@RestController
@RequestMapping(value = "/curtir")
public class CurtidaController {
	

	@Autowired
	private CurtidaService curtidaService;
	
	@GetMapping
	public ResponseEntity Listar() {
		try {
			List<Curtida> curtidas = curtidaService.listarTodos();
			return new ResponseEntity(curtidas, HttpStatus.OK);	
		}catch(Exception e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
		try {
			Curtida curtida = curtidaService.buscarPorId(id);
			return new ResponseEntity(curtida, HttpStatus.OK);	
		}catch(Exception e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/comentario/{idComentario}")
	public ResponseEntity salvarCurtidaComentario(@PathVariable ("idComentario") Long idComentario, @RequestBody CurtidaDTO curtidaDTO) {
		try {
			Curtida curtida = curtidaService.salvarCurtidaComentario(idComentario, curtidaDTO);
			return new ResponseEntity(curtida, HttpStatus.OK);	
		}catch(Exception e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/post/{idPostagem}")
	public ResponseEntity salvarCurtidaPost(@PathVariable ("idPostagem") Long idPostagem, @RequestBody CurtidaDTO curtidaDTO) {
		try {
			Curtida curtida = curtidaService.salvarCurtidaPost(idPostagem, curtidaDTO);
			return new ResponseEntity(curtida, HttpStatus.OK);	
		}catch(Exception e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
