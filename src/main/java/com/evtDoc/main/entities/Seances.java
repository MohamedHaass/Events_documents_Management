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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SEANCES")
@Data @AllArgsConstructor @NoArgsConstructor
public class Seances {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="DATE_EVT")
	@Temporal(TemporalType.TIME)
	private Date dateEvt;
	
	@Column(name="INTERVAL_SEANCE")
	private String intvSeance; // interval de seance (créneau temporel)
	
	@JsonProperty(access = Access.READ_ONLY)
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "seances")
	private Collection<Evenements> evenements = new ArrayList<>();
	
	@OneToOne
	private Salles salles;
	
}
