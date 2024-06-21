package com.bluewater.FIA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Pilote {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nom;
	
	@OneToOne
	private Voiture voiture;

	public Pilote(String nom, Voiture voiture) {
		super();
		this.nom = nom;
		this.voiture = voiture;
	}
	
	
}
