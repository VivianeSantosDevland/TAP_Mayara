package com.devland.meupresente.models;


import java.util.Set;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Data
@Entity(name = "listaPresente")
public class ListaPresente {

	
	@Id
	@GeneratedValue
	private Long idList;	
	private String nomeList;
	private String linkShareableList;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_user", nullable = false, updatable = false)
	private Usuario usuario;
	
	public Long getUsuario() {
		
		return usuario.getIdUser();
	}
	

	
	@OneToMany(mappedBy = "listaPresente")
	Set<ListHasProduct> listhasproduct;
	
	
}
