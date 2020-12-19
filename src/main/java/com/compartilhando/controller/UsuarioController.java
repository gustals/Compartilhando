package com.compartilhando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.compartilhando.classificador.TipoImagem;
import com.compartilhando.model.RelacionamentoUsuarios;
import com.compartilhando.model.Usuario;
import com.compartilhando.repository.RelacionamentoUsuariosRepository;
import com.compartilhando.repository.UsuarioRepository;
import com.compartilhando.service.ImagemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
		
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RelacionamentoUsuariosRepository relacionamentoUsuariosRepository;
	@Autowired
	private ImagemService imagemService;
	
	@GetMapping("/")
	public List<Usuario> Listar(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable("id") Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	@PostMapping
	public Usuario cadastrarUsuario(@RequestParam(value = "file", required = false) MultipartFile file,@RequestParam String novoUsuarioString) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Usuario user = mapper.readValue(novoUsuarioString.toString(), Usuario.class);
		usuarioRepository.save(user);
		
		String pathImagem = imagemService.salvarFoto(TipoImagem.USUARIO, user.getId(), file);
		user.setPathImagem(pathImagem);
		
		return usuarioRepository.save(user);
	}
	
	@PostMapping("/seguir")
	public Usuario seguir(@RequestParam Long usuarioDonoDoPerfil, @RequestParam Long usuarioSeguido) {
		Usuario userDonoDoPerfil=usuarioRepository.findById(usuarioDonoDoPerfil).get();
		Usuario userSeguido = usuarioRepository.findById(usuarioSeguido).get();
		
		for(RelacionamentoUsuarios Ruser: userDonoDoPerfil.getSeguindo()) {
			if(Ruser.getRelacionado().equals(usuarioSeguido))
				return userDonoDoPerfil;
		}	
		
		userDonoDoPerfil.addSeguindo(relacionamentoUsuariosRepository.save(new RelacionamentoUsuarios(usuarioSeguido)));
		usuarioRepository.save(userDonoDoPerfil);
		
		userSeguido.addSeguidores(relacionamentoUsuariosRepository.save(new RelacionamentoUsuarios(usuarioDonoDoPerfil)));
		usuarioRepository.save(userSeguido);
		
		return userDonoDoPerfil;
	}
	
}
