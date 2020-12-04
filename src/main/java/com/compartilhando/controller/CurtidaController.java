package com.compartilhando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compartilhando.model.Curtida;
import com.compartilhando.model.Usuario;
import com.compartilhando.repository.CurtidaRepository;

@RestController
@RequestMapping(value = "/Curtida")
public class CurtidaController {
	
	@Autowired
	private CurtidaRepository curtidaRepository;
	
	@GetMapping
	public List<Curtida> Listar() {
		return (List<Curtida>) curtidaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Curtida buscarPorId(@PathVariable("id") Long id) {
		return curtidaRepository.findById(id).get();
	}
	
	@PostMapping
	public Curtida salvarCurtida(@RequestBody Curtida curtida) {
		return curtidaRepository.save(curtida);
	}

}
