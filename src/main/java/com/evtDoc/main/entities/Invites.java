package com.evtDoc.main.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "INVITES")
@Data @AllArgsConstructor @NoArgsConstructor
public class Invites {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TEL")
	private String tel;
	
	@Column(name="PHOTO_INVITE")
	private String photoInv;
	
	@JsonProperty(access = Access.READ_ONLY)
	@ManyToMany(mappedBy = "invites",fetch = FetchType.EAGER)
	private Collection<Evenements> evenements = new ArrayList<>();

}
