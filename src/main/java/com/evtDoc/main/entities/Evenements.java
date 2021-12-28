package com.evtDoc.main.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EVENEMENTS")
@Data @AllArgsConstructor @NoArgsConstructor
public class Evenements {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="INTITULE_EVT")
	private String intituleEvt;
	
	@Column(name="LIEU_EVT")
	private String lieuEvt;
	
	@Column(name="POSTERE_EVT")
	private String postereEvt;
	
	@Column(name="DESCRIPTION_EVT")
	private String descriptionEvt;
	
	@Column(name="STATUS_EVT")
	private String status;

	@OneToMany(mappedBy = "evenements")
	private Collection<Documents> documents;
	
	@ManyToMany(fetch =  FetchType.EAGER)
	private Collection<Invites> invites = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Seances> seances = new ArrayList<>();

}
