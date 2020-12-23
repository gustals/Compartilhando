package com.compartilhando.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compartilhando.model.Comentario;
import com.compartilhando.model.Curtida;
import com.compartilhando.model.Postagem;
import com.compartilhando.model.Usuario;
import com.compartilhando.model.dto.CurtidaDTO;
import com.compartilhando.repository.ComentarioRepository;
import com.compartilhando.repository.CurtidaRepository;
import com.compartilhando.repository.PostRepository;
import com.compartilhando.repository.UsuarioRepository;

@Service
public class CurtidaService {
	
	@Autowired
	private CurtidaRepository curtidaRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PostRepository postRepository;
	
	
	public List<Curtida> listarTodos() {
		return (List<Curtida>) curtidaRepository.findAll();
	}
	
	public Curtida buscarPorId(Long id) {
		return curtidaRepository.findById(id).get();
	}
	
	public Curtida salvarCurtidaComentario(Long id, CurtidaDTO curtidaDTO) {
		Comentario comentario = comentarioRepository.findById(id).get();
		Usuario usuario = usuarioRepository.findById(curtidaDTO.getIdenficadorUsuario()).get();
		Curtida curtida= new Curtida(usuario);
		curtidaRepository.save(curtida);
		comentario.addCurtidas(curtida);
		comentarioRepository.save(comentario);
		
		return curtida;
	}
	
	public Curtida salvarCurtidaPost(Long id, CurtidaDTO curtidaDTO) {
		Postagem post = postRepository.findById(id).get();
		Usuario usuario = usuarioRepository.findById(curtidaDTO.getIdenficadorUsuario()).get();
		Curtida curtida= new Curtida(usuario);
		curtidaRepository.save(curtida);
		post.addCurtidas(curtida);
		postRepository.save(post);
		
		return curtida;
	}
	
}
