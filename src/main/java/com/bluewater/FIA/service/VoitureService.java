package com.bluewater.FIA.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.bluewater.FIA.model.Voiture;

public interface VoitureService {
	
	public void addCarToPilote(Long id, Voiture voiture);
	public List<Voiture> getAll();
	public void createCar(Voiture voiture);
	public void deleteById(Long id);
	Voiture getById(Long id);

}
