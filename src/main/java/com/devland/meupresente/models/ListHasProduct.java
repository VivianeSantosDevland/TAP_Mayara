package com.devland.meupresente.models;



import lombok.Data;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;


@Data
@Entity(name = "list_has_product")

public class ListHasProduct {


	
	@EmbeddedId
	ListPresentProduct idListProduct;//chave composta
	@ManyToOne
	@MapsId("idLista")
	@JoinColumn(name = "id_list")
	ListaPresente listaPresente;
	
	@ManyToOne
	@MapsId("idProduto")
	@JoinColumn(name = "id_product")
	Produto produto;
	
	private boolean assinado;
	private String nomeAssinador;
	
	
}
