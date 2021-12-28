package com.evtDoc.main.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SALLES")
@Data @AllArgsConstructor @NoArgsConstructor
public class Salles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOM_SALLE")
	private String nomSalle;
	
	@Column(name="NOMBRE_PLACES")
	private int nombrePlaces;
	
	@OneToMany(mappedBy = "salles",fetch = FetchType.LAZY)
	private List<Seances> seances = new ArrayList<>();

}
