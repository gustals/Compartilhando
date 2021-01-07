package com.compartilhando.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.compartilhando.exception.RegraDeNegocioException;
import com.compartilhando.model.Usuario;
import com.compartilhando.model.dto.UsuarioCreateDTO;
import com.compartilhando.model.dto.UsuarioUpdateDTO;
import com.compartilhando.service.UsuarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/usuario")
@Api(value="Endpoints de usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
			
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public ResponseEntity listarTodos(){
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
		}catch(RegraDeNegocioException e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity cadastrarUsuario(@RequestBody UsuarioCreateDTO novoUsuario) throws JsonProcessingException {
		
		try {
			Usuario usuarioCriado = usuarioService.salvarUsuario(novoUsuario);
			return new ResponseEntity(usuarioCriado, HttpStatus.CREATED);	
		}catch(RegraDeNegocioException e){		
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	 
	}
	
	@PutMapping("/editar")
	public ResponseEntity alterarUsuario(@RequestBody UsuarioUpdateDTO novoUsuario) throws JsonProcessingException {
		
		try {
			Usuario usuarioAlt= usuarioService.alterarUsuario(novoUsuario);
			return new ResponseEntity(usuarioAlt, HttpStatus.OK);		
		}catch(Exception e){			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	@PostMapping("/seguir")
	public ResponseEntity seguir(@RequestParam Long IDusuarioDonoDoPerfil, @RequestParam Long IDusuarioSeguido) {	
		
		try {
			usuarioService.seguirUsuario(IDusuarioDonoDoPerfil, IDusuarioSeguido);
			return new ResponseEntity(HttpStatus.OK);		
		}catch(Exception e){			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
