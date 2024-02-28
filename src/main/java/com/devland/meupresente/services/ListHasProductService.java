package com.devland.meupresente.services;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devland.meupresente.models.ListHasProduct;
import com.devland.meupresente.repositorys.ListHasProductRepository;

@Service
public class ListHasProductService {

	@Autowired
	private ListHasProductRepository lpRepo;	
/*##########################################################################*/
	
	public ListHasProduct create(ListHasProduct listaProduto) 
	{
		ListHasProduct newListProduct;
		newListProduct = this.lpRepo.save(listaProduto);
		System.out.println(listaProduto);
		return newListProduct;
	}
	
/*##########################################################################*/
	
/*##########################################################################*/
	
/*##########################################################################*/
	
/*##########################################################################*/
	
/*##########################################################################*/
	
}
