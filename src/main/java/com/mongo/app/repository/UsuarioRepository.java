package com.mongo.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.app.entity.Usuario;

/**
*
* @author andres
*/
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Integer>{

	/** 
	 * metodo que Obtiene usuario por su email
	 * @param email String que contiene el email
	 * */
	public Optional<Usuario> findByEmail(String email);
	
	/** 
	 * metodo que lista usuarios por mes de cumpleaños
	 * @param mes cadena que contiene el mes de cumpleaños
	 * */
	public List<Usuario> findByMonthBirthtDay(String mes);
}
