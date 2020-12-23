package com.compartilhando.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.compartilhando.exception.RegraDeNegocioException;
import com.compartilhando.model.Usuario;
import com.compartilhando.model.dto.UsuarioDTO;
import com.compartilhando.service.UsuarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
			
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public ResponseEntity Listar(){
		try {
			List<Usuario> usuarios = usuarioService.listarTodos();
			return new ResponseEntity(usuarios, HttpStatus.OK);	
		}catch(Exception e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable("id") Long id) {
		
		try {
			Usuario usuario = usuarioService.buscarPorId(id);
			return new ResponseEntity(usuario, HttpStatus.OK);	
		}catch(Exception e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	

	@PostMapping
	public ResponseEntity cadastrarUsuario(@RequestParam(value = "file", required = false) MultipartFile file,
									@RequestParam String novoUsuarioString) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		UsuarioDTO userDTO = mapper.readValue(novoUsuarioString.toString(), UsuarioDTO.class);
		
		try {
			Usuario usuarioCriado = usuarioService.salvarUsuario(file, userDTO);
			return new ResponseEntity(usuarioCriado, HttpStatus.CREATED);	
		}catch(RegraDeNegocioException e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	 
	}
	
	@PostMapping("/alterar")
	public ResponseEntity alterarUsuario(@RequestParam(value = "file", required = false) MultipartFile file,
									@RequestParam String usuarioAlterado) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		UsuarioDTO userDTO = mapper.readValue(usuarioAlterado.toString(), UsuarioDTO.class);
		
		try {
			Usuario usuarioAlt= usuarioService.alterarUsuario(file, userDTO);
			return new ResponseEntity(usuarioAlt, HttpStatus.OK);		
		}catch(Exception e){			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@PostMapping("/seguir")
	public ResponseEntity seguir(@RequestParam Long usuarioDonoDoPerfil, @RequestParam Long usuarioSeguido) {	
		
		try {
			usuarioService.seguirUsuario(usuarioDonoDoPerfil, usuarioSeguido);
			return new ResponseEntity(HttpStatus.OK);		
		}catch(Exception e){			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
