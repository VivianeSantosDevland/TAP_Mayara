package com.devland.meupresente.services;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.devland.meupresente.controllers.UtilsController;
import com.devland.meupresente.models.Usuario;
import com.devland.meupresente.repositorys.UsuarioRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

@Autowired
private UsuarioRepository userRepo;	

/*##########################################################################*/
@Transactional
public Usuario create(Usuario user) 
{	Usuario newUser;
	String nome = user.getNomeUser();
	Usuario nameUserFound = userRepo.findByName(nome);
	if(nameUserFound != null) {
		newUser = null;
	}else {
		if(user.getPasswordUser() != null) 
		{
			//criptografando a senha para guardar na base de dados
			var passwordHashed = BCrypt.withDefaults().hashToString(12, user.getPasswordUser().toCharArray());
			user.setPasswordUser(passwordHashed);
		}
		newUser = this.userRepo.save(user);
	}
	

	
	return newUser;
}
/*##########################################################################*/
public Usuario findById(Long id)
{
	Optional<Usuario> user = this.userRepo.findById(id);
	return user.orElseThrow( () -> new RuntimeException
	(
			"Usuário não encontrado na base de dados"
	));
}
/*##########################################################################*/
@Transactional
public Usuario update(Usuario user, Long id) 
{
	var searchUser = this.userRepo.findById(id).orElse(null);
	
	if(searchUser == null) {
		return null;
	}
	//caso a senha tenha sido alterada, deve-se criptografar antes de salvar:	
	if(user.getPasswordUser() != null)
	{
		var passwordHashed = BCrypt.withDefaults().hashToString(12, user.getPasswordUser().toCharArray());
		user.setPasswordUser(passwordHashed);
	}
	UtilsController.copyNonNullProperty(user, searchUser);	
	Usuario userUpdate = this.userRepo.save(searchUser);
	return userUpdate;
	
}
/*##########################################################################*/
public String delete(Long id) {
	findById(id);
	try {
		this.userRepo.deleteById(id);
		return "Usuário excluido do sistema";
	} catch (Exception e) {
		throw new RuntimeException("Não foi possível deletar a conta.");
	}
	
}
/*

public Usuario findByName(String name) 
{
	Usuario user = this.userRepo.findByName(name);
	return user;
}


public Usuario findByEmail(String email) 
{
	Usuario user = this.userRepo.findByEmail(email);
	return user;
}
*/

	
}
