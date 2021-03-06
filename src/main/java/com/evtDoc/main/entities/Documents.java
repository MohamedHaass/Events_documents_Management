package com.evtDoc.main.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DOCUMENTS")
@Data @AllArgsConstructor @NoArgsConstructor
public class Documents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TYPE_DOCUMENT")
	private String typeDocument;
	
	@Column(name="NOM_FICHIER")
	private String nomFichier;
	
	@Column(name="CHEMIN_FICHIER")
	private String cheminFichier;
	
	@Column(name="DATE_INSERTION")
	private Date dateInsertion;
	
	@ManyToOne
	@JsonProperty(access = Access.READ_ONLY)
	private Evenements evenements;

}
