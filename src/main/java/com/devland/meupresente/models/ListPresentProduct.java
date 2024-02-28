package com.devland.meupresente.models;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;




@Embeddable
public class ListPresentProduct implements Serializable{
	
    /**
     * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_list")
    private Long idLista;

   @Column(name = "id_product")
    private Long idProduto;


}
