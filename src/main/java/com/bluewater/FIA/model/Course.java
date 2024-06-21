package com.bluewater.FIA.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nom;
	private String pays;
	private LocalDate startDate;
	
	@OneToMany
	private List<Pilote> pilotes;

	public Course(String nom, String pays) {
		this.nom = nom;
		this.pays = pays;
		this.pilotes = null;
	}
	
	

}
