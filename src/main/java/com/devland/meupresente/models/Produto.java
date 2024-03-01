package com.devland.meupresente.models;

import java.sql.Blob;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Data
@Entity(name = "produto")
public class Produto {
	
	
	@Id
	@GeneratedValue
	private Long idProduct;	
	private String nomeProduct;
	private String descricaoProduct;
	private Blob fotoProduct;	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String linkLojaProduct;	
	private boolean assinado;
	private String nomeAssinador;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_list", nullable = false, updatable = false)
	private ListaPresente listaPresente;
	
	public Long getListaPresente() {
		
		return listaPresente.getIdList();
	}

}
