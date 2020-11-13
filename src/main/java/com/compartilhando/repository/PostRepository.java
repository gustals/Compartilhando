package com.compartilhando.repository;

import org.springframework.data.repository.CrudRepository;

import com.compartilhando.model.Post;


public interface PostRepository extends CrudRepository<Post, Long>{

}
