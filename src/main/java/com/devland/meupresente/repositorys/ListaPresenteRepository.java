package com.devland.meupresente.repositorys;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devland.meupresente.models.ListaPresente;

public interface ListaPresenteRepository extends JpaRepository<ListaPresente, Long>{

	
	//não usar essa verificação
	@Query(value = "SELECT lista_presente.id_list, lista_presente.nome_list, "
			+ "lista_presente.link_shareable_list "
			+ "from lista_presente INNER JOIN usuario "
			+ "WHERE lista_presente.id_user = usuario.id_user "
			+ "AND lista_presente.id_user = :id "
			+ "AND nome_list = :nomeList;", nativeQuery = true)
	ListaPresente findByName(Long id, String nomeList);
	
//vou precisar usar essa verificação
	@Query(value = "SELECT lista_presente.id_user, id_list, link_shareable_list, nome_list from lista_presente, usuario WHERE lista_presente.id_user = usuario.id_user AND usuario.id_user = :id", nativeQuery = true)
	List<ListaPresente> findAllListsByIdUser(Long id);

}
