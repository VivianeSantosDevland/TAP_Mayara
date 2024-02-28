package com.devland.meupresente.models;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;



@Data
@Entity(name = "usuario")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user", updatable = false, nullable = false, unique = true)
	private Long idUser;
	
	@Column(unique = true)	
	private String nomeUser;
	private String passwordUser;
	private String emailUser;
	
	@Lob
	@Column(name="fotoUser", columnDefinition = "mediumblob")
	private byte[] fotoUser;
		
	private String enderecoUser;
	
	@CreationTimestamp
	private LocalDateTime dataCadastroUser; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<ListaPresente> listasPresentes;
	
	@JsonIgnore
	public List<ListaPresente> getListasPresentes()
	{
		return listasPresentes;
	}
	
	
	
	
}
