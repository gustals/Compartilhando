package com.compartilhando.repository;

import org.springframework.data.repository.CrudRepository;

import com.compartilhando.model.Comentario;

public interface ComentarioRepository extends CrudRepository<Comentario, Long> {

}
