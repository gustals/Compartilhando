package com.compartilhando.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.compartilhando.enums.TipoImagem;
import com.compartilhando.exception.RegraDeNegocioException;
import com.compartilhando.model.RelacionamentoUsuarios;
import com.compartilhando.model.Usuario;
import com.compartilhando.model.dto.UsuarioCreateDTO;
import com.compartilhando.model.dto.UsuarioUpdateDTO;
import com.compartilhando.repository.RelacionamentoUsuariosRepository;
import com.compartilhando.repository.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RelacionamentoUsuariosRepository relacionamentoUsuariosRepository;
	//@Autowired
	//private ImagemService imagemService;
	@Value("${compartilhando.imagens.fotos.perfilPadrao}")
	private String fotoPadraoUsuario;
	

	public List<Usuario> listarTodos(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	
	public Usuario buscarPorId(Long id) {
		
		if(!usuarioRepository.findById(id).isPresent()) {
			throw new RegraDeNegocioException("Usuario não existe");
		}
		return usuarioRepository.findById(id).get();
	}

	public Usuario salvarUsuario(UsuarioCreateDTO novoUsuario) throws JsonMappingException, JsonProcessingException {
		
		if(validarUsuario(novoUsuario.getEmail())) {
			throw new RegraDeNegocioException("Email ja esta em uso por outro usuario!");
		}
		
		Usuario user = new Usuario(novoUsuario.getEmail(), novoUsuario.getSenha(), novoUsuario.getNome(), novoUsuario.getPathImagem());
		
		if(user.getPathImagem().equals("")) 
			user.setPathImagem(fotoPadraoUsuario);
		
		return usuarioRepository.save(user);
	}
	
	public Usuario alterarUsuario(UsuarioUpdateDTO usuarioAlterado) throws JsonMappingException, JsonProcessingException {
		
		Usuario user = usuarioRepository.findById(usuarioAlterado.getId()).get();
		user.setSenha(usuarioAlterado.getSenha());
		user.setNome(usuarioAlterado.getNome());
		user.setPathImagem(usuarioAlterado.getPathImagem());
		
		return usuarioRepository.save(user);
	}
	
	public boolean validarUsuario(String email) {
		return usuarioRepository.existsByEmail(email);
	}
	
	public Usuario seguirUsuario(Long usuarioDonoDoPerfil, Long usuarioSeguido) {
		Usuario userDonoDoPerfil=usuarioRepository.findById(usuarioDonoDoPerfil).get();
		Usuario userSeguido = usuarioRepository.findById(usuarioSeguido).get();
		
		for(RelacionamentoUsuarios Ruser: userDonoDoPerfil.getSeguindo()) {
			if(Ruser.getusuarioId().equals(usuarioSeguido))
				return deixarDeSeguir(userDonoDoPerfil, userSeguido);
		}	
		
		userDonoDoPerfil.addSeguindo(relacionamentoUsuariosRepository.save(new RelacionamentoUsuarios(usuarioSeguido)));
		usuarioRepository.save(userDonoDoPerfil);
		
		userSeguido.addSeguidores(relacionamentoUsuariosRepository.save(new RelacionamentoUsuarios(usuarioDonoDoPerfil)));
		usuarioRepository.save(userSeguido);
		
		return userDonoDoPerfil;
	}
	
	public Usuario deixarDeSeguir(Usuario userDonoDoPerfil, Usuario userSeguido) {
		userDonoDoPerfil.getSeguindo().remove(relacionamentoUsuariosRepository.findByUsuarioId(userSeguido.getId()));
		userSeguido.getSeguidores().remove(relacionamentoUsuariosRepository.findByUsuarioId(userDonoDoPerfil.getId()));
		usuarioRepository.save(userDonoDoPerfil);
		usuarioRepository.save(userSeguido);
		return userDonoDoPerfil;
	}
	
}
