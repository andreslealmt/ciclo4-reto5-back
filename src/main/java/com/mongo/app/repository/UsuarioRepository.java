package com.mongo.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.app.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, Integer>{

	public Optional<Usuario> findByEmail(String email);
	
	public List<Usuario> findByMonthBirthtDay(String mes);
}
