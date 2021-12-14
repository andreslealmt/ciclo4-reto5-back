package com.mongo.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.app.entity.Usuario;
import com.mongo.app.pojo.UsuarioPojo;
import com.mongo.app.services.UsuarioService;

/**
*
* @author andres
*/

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {
	
	/** injectando bean UsuarioService */
	@Autowired private UsuarioService usuarioService;
	
	
	/** metodo que lista todos los usuarios */
	@GetMapping("/all")
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	/** 
	 * metodo que guarda una usuario 
	 * @param usuario instancia de la clase Usuario recibido por POST
	 * */
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario save(@RequestBody Usuario usuario) {
		return usuarioService.saveUser(usuario);
	}
	
	/** 
	 * metodo que obtiene un usuario por su id
	 * @param id identificador unico de la entida usuario
	 * */	
	@GetMapping("/{id}")
	public Optional<Usuario> getUsuario(@PathVariable(value = "id") int userId){
		return usuarioService.getUsuario(userId);
	}
	
	
	/** 
	 * metodo actualiza un usuario 
	 * @param usuario instancia de la clase Usuario recibido por POST
	 * */
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario updateUsuario(@RequestBody Usuario usuario) {
		Optional<Usuario> oUsuario = usuarioService.getUsuario(usuario.getId());
		if(oUsuario.isEmpty()) {
			return usuario;
		}
		
		oUsuario.get().setIdentification(usuario.getIdentification());
		oUsuario.get().setName(usuario.getName());
		oUsuario.get().setAddress(usuario.getAddress());
		oUsuario.get().setCellPhone(usuario.getCellPhone());
		oUsuario.get().setEmail(usuario.getEmail());
		oUsuario.get().setPassword(usuario.getPassword());
		oUsuario.get().setZone(usuario.getZone());
		oUsuario.get().setType(usuario.getType());
		
		return usuarioService.saveUser(oUsuario.get());
		
	}
	
	/** 
	 * metodo que elimina un usuario 
	 * @param id identificador unico para eliminar usuario 
	 * */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUsuario(@PathVariable(value = "id") int userId) {
		usuarioService.deleteUsuario(userId);
	}
	
	/** 
	 * metodo que la existencia de un usuario 
	 * @param email identificar si el email existe en DB 
	 * */
	@GetMapping("/emailexist/{email}")
	public Boolean emailExist(@PathVariable String email) {
		if(usuarioService.emailExist(email).isPresent()) {
			return true;
		}
		
		return false;
	}
	
	
	/** 
	 * metodo que autentica al usuario
	 * @param email correo con el que se registra el usuario
	 * @param password contraseña del usuario  
	 * */
	@GetMapping("/{email}/{password}")
	public Object autenticar(@PathVariable String email, @PathVariable String password) {
		Optional<Usuario> oUser = usuarioService.emailExist(email);
		if(oUser.isPresent()) {
			if(oUser.get().getPassword().equals(password)) {
				return oUser.get();
			}
		}		
		return new UsuarioPojo(null, null, null, null, null, null, null, null, null);		
	}
	
	@GetMapping("/birthday/{mes}")
	public List<Usuario> getMonth(@PathVariable String mes){
		return usuarioService.getMonth(mes);
	}
	
	
	
	
	
	

}
