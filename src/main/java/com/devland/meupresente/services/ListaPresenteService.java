package com.devland.meupresente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devland.meupresente.controllers.UtilsController;
import com.devland.meupresente.models.ListaPresente;
import com.devland.meupresente.models.Produto;
import com.devland.meupresente.repositorys.ListaPresenteRepository;

@Service
public class ListaPresenteService {

	@Autowired
	private ListaPresenteRepository listaRepo;
/*##########################################################################*/		
	public ListaPresente create(ListaPresente lista) 
	{
		ListaPresente newLista;
		newLista = this.listaRepo.save(lista);
		return newLista;
	}
/*##########################################################################*/	
	public ListaPresente update(ListaPresente lista, Long id) {
		var searchLista = this.listaRepo.findById(id).orElse(null);
		
		if(searchLista == null) {
			return null;
		}
		UtilsController.copyNonNullProperty(lista, searchLista);
		ListaPresente listaUpdate = this.listaRepo.save(searchLista);
		return listaUpdate;
	}
/*##########################################################################*/	
	public List<ListaPresente> getAll(Long id)
	{
		//var listas = this.listaRepo.findAll();
		List<ListaPresente> listas = this.listaRepo.findAllListsByIdUser(id);
		return listas;
	}
/*##########################################################################*/	
	public String delete(Long id) 
	{
		try {
			this.listaRepo.deleteById(id);
			return "Lista excluída do sistema";
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível deletar a lista.");
		}
	}
/*##########################################################################*/	

	public ListaPresente findById(Long id) 
	{
		Optional<ListaPresente> searchList = this.listaRepo.findById(id);
		return searchList.orElseThrow( () -> new RuntimeException
		(
			"Lista não econtrado na base de dados"
		));
		
	}
/*##########################################################################*/	
}
