package com.devland.meupresente.repositorys;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devland.meupresente.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "select *from usuario where nome_user = :name", nativeQuery = true)
	Usuario findByName(String name);


	
	//public Usuario findByName(String nome);
	//public Usuario findByEmail(String email);

}
