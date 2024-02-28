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
import com.devland.meupresente.models.Produto;
import com.devland.meupresente.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
/*------------------------------------------------------------------------ */	
	@PostMapping("/")
	public ResponseEntity<Produto> create(@RequestBody Produto produto)
	{
		Produto newProduto = this.produtoService.create(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(newProduto);
	}
/*------------------------------------------------------------------------ */
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable("id") Long id)
	{
		Produto newProduto = this.produtoService.update(produto, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(newProduto);
	}
	
/*------------------------------------------------------------------------ */
	@GetMapping("/")
	public List<Produto> getAll()
	{
		var produtos = this.produtoService.getAll();
		return produtos;
	}
	
/*------------------------------------------------------------------------ */	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id)
	{
		Produto searchProduto = this.produtoService.findById(id);
		return ResponseEntity.ok().body(searchProduto);
	}
/*------------------------------------------------------------------------ */	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		this.produtoService.delete(id);
	}
	
}
