package com.devland.meupresente.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devland.meupresente.models.ListHasProduct;
import com.devland.meupresente.services.ListHasProductService;

@RestController
@RequestMapping("/listaDetails")
public class ProdutosDaListaController {

	private ListHasProductService listProdService;
	
	/*------------------------------------------------------------------------ */
	
	@PostMapping("/")
	public ResponseEntity create(@RequestBody ListHasProduct listaProduto) {
		ListHasProduct newListaProduto = this.listProdService.create(listaProduto);
		if(newListaProduto == null) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Ocorreu um erro ao tentar adicionar o produto");
		}
		//na verdade melhor retornar a lista com seus produtos
		return ResponseEntity.status(HttpStatus.CREATED).body(newListaProduto);
	}
	/*------------------------------------------------------------------------ */
		
	/*------------------------------------------------------------------------ */
		
	/*------------------------------------------------------------------------ */
		
	/*------------------------------------------------------------------------ */
		
	/*------------------------------------------------------------------------ */
}
