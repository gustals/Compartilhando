package com.compartilhando.repository;

import org.springframework.data.repository.CrudRepository;

import com.compartilhando.model.RelacionamentoUsuarios;

public interface RelacionamentoUsuariosRepository extends CrudRepository<RelacionamentoUsuarios, Long> {
	
	RelacionamentoUsuarios findByUsuarioId(Long usuarioId);
	
}
