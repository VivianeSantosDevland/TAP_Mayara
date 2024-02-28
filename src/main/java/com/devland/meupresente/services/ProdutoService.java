package com.devland.meupresente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devland.meupresente.controllers.UtilsController;
import com.devland.meupresente.models.Produto;
import com.devland.meupresente.repositorys.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepo;
/*##########################################################################*/	
	@Transactional
	public Produto create(Produto produto) 
	{
		Produto newProduto = this.produtoRepo.save(produto);
		return newProduto;
	}
/*##########################################################################*/
	@Transactional
	public Produto update(Produto produto, Long id) 
	{
		var searchProduto = this.produtoRepo.findById(id).orElse(null);
		
		if(searchProduto == null) {
			return null;
		}
		UtilsController.copyNonNullProperty(produto, searchProduto);
		Produto produtoUpdate = this.produtoRepo.save(searchProduto);
		return produtoUpdate;
	}
/*##########################################################################*/	
	public Produto findById(Long id) 
	{
		Optional<Produto> produto = this.produtoRepo.findById(id);
		return produto.orElseThrow( () -> new RuntimeException
		(
			"Produto não econtrado na base de dados"
		));
	}
/*##########################################################################*/
	
	public List<Produto> getAll()
	{
		var produtos = this.produtoRepo.findAll();
		return produtos;
	}
/*##########################################################################*/	
	public String delete(Long id) 
	{
		try {
			this.produtoRepo.deleteById(id);
			return "Produto excluído do sistema";
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível deletar o produto.");
		}
	}
	
	
}
