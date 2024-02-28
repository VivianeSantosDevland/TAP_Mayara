package com.devland.meupresente.controllers;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import at.favre.lib.crypto.bcrypt.BCrypt;
import com.devland.meupresente.models.Usuario;
import com.devland.meupresente.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

/*------------------------------------------------------------------------ */	
	@PostMapping("/")
	public ResponseEntity create(@RequestBody Usuario user)
	{
		Usuario userCreated = this.usuarioService.create(user);		
		if(userCreated == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome de usuário já existe. Tente outro nome");
		}else
		return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
		
	}
/*------------------------------------------------------------------------ */		
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id)
	{
		Usuario user = this.usuarioService.findById(id);
		return ResponseEntity.ok().body(user);
	}
/*------------------------------------------------------------------------ */		
	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody Usuario user, @PathVariable("id") Long id) 
	{
		Usuario userUpdated = this.usuarioService.update(user, id);
		return ResponseEntity.ok().body(userUpdated);
	}
/*------------------------------------------------------------------------ */	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) 
	{
	
		String response = this.usuarioService.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

}
