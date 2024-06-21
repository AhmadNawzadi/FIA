package com.bluewater.FIA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Voiture {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nom;
	private int vitesse;
	
	public Voiture(String nom, int vitesse) {
		super();
		this.nom = nom;
		this.vitesse = vitesse;
	}
	
	

}
