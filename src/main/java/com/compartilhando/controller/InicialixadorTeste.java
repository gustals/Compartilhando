package com.compartilhando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compartilhando.model.Comentario;
import com.compartilhando.model.Usuario;
import com.compartilhando.repository.ComentarioRepository;
import com.compartilhando.repository.PostRepository;
import com.compartilhando.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/popular")
public class InicialixadorTeste {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public void Listar() {
		Usuario u1= new Usuario("GUstavo.lopes1@gamil.com", "123");
		usuarioRepository.save(u1);
		Usuario u2= new Usuario("GUstavo.lopes2@gamil.com", "1234");
		usuarioRepository.save(u2);
		Usuario u3= new Usuario("GUstavo.lopes3@gamil.com", "1235");
		usuarioRepository.save(u3);
		Usuario u4= new Usuario("GUstavo.lopes4@gamil.com", "1236");
		usuarioRepository.save(u4);
		Usuario u5= new Usuario("GUstavo.lopes5@gamil.com", "1237");
		usuarioRepository.save(u5);
	}

}
