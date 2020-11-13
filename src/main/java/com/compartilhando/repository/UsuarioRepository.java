package com.compartilhando.repository;

import org.springframework.data.repository.CrudRepository;

import com.compartilhando.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
