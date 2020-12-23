package com.compartilhando.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compartilhando.model.Comentario;
import com.compartilhando.model.Postagem;
import com.compartilhando.model.Usuario;
import com.compartilhando.model.dto.ComentarioDTO;
import com.compartilhando.repository.ComentarioRepository;
import com.compartilhando.repository.PostRepository;
import com.compartilhando.repository.UsuarioRepository;

@Service
public class ComentarioService {
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<Comentario> listarTodos() {
		return (List<Comentario>) comentarioRepository.findAll();
	}
	
	public Comentario salvarComentarioPost(Long id, ComentarioDTO comentarioDTO) {
		Usuario usuario = usuarioRepository.findById(comentarioDTO.getIdenficadorUsuario()).get();
		Comentario comentario = new Comentario(usuario, comentarioDTO.getDescricaoComentario());
		
		comentario.setDateHoraComentario(LocalDateTime.now());
		comentarioRepository.save(comentario);
		Postagem post= postRepository.findById(id).get();
		post.addComentarios(comentario);
		postRepository.save(post);
		return comentario;
	}
}
