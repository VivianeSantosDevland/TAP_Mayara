package com.devland.meupresente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devland.meupresente.models.ListaPresente;
import com.devland.meupresente.services.ListaPresenteService;

@RestController
@RequestMapping("/lista")
public class ListaController {

	@Autowired
	private ListaPresenteService listaService;
	
/*------------------------------------------------------------------------ */
	@PostMapping("/")
	public ResponseEntity create(@RequestBody ListaPresente lista)
	{
		ListaPresente newLista = this.listaService.create(lista);
		if(newLista == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro.");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(newLista);
	}
/*------------------------------------------------------------------------ */
	@GetMapping("/minhasListas/{idUser}")
	public List<ListaPresente> getAllListsUser(@PathVariable Long idUser){
		System.out.println(idUser);
		var listas = this.listaService.getAll(idUser);
		System.out.println(listas);
		return listas;
	}
	
/*------------------------------------------------------------------------ */
	@PutMapping("/{id}")
	public ResponseEntity<ListaPresente> update(@RequestBody ListaPresente lista, @PathVariable("id") Long id) 
	{	
		ListaPresente listaUpdated = this.listaService.update(lista, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(listaUpdated);
	}
/*------------------------------------------------------------------------ */	
	@GetMapping("/{id}")
	public ResponseEntity<ListaPresente> findById(@PathVariable Long id)
	{
		ListaPresente searchLista = this.listaService.findById(id);
		return ResponseEntity.ok().body(searchLista);
	}
/*------------------------------------------------------------------------ */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		this.listaService.delete(id);
	}
/*------------------------------------------------------------------------ */
}
