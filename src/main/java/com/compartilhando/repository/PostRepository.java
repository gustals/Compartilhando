package com.compartilhando.repository;

import org.springframework.data.repository.CrudRepository;

import com.compartilhando.model.Postagem;


public interface PostRepository extends CrudRepository<Postagem, Long>{

}
