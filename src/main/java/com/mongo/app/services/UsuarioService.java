package com.mongo.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.app.entity.Usuario;
import com.mongo.app.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired private UsuarioRepository usuarioRepository;
	
	public List<Usuario>  getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Usuario saveUser(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> getUsuario(int id){
		return usuarioRepository.findById(id);
	}
	
	public void deleteUsuario(int id) {
		usuarioRepository.deleteById(id);
	}
	
	public Optional<Usuario> emailExist(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public List<Usuario> getMonth(String mes){		
		return usuarioRepository.findByMonthBirthtDay(mes);
	}

}
