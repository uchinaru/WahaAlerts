package com.jb.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.jb.models.Usuario;

public interface UserRepository extends ListCrudRepository<Usuario, Integer>{
	
	public Usuario findByContato(String contato);

}
