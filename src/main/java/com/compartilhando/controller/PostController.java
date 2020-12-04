package com.compartilhando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compartilhando.model.Post;
import com.compartilhando.repository.PostRepository;

@RestController
@RequestMapping(value = "/post")
public class PostController {
	@Autowired
	private PostRepository postRepository;
	
	
	@GetMapping
	public List<Post> Listar() {
		return (List<Post>) postRepository.findAll();
	}
	
	@PostMapping
	public Post salvarPost(@RequestBody Post post) {
		return postRepository.save(post);
	}
}
