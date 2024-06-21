package com.bluewater.FIA.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bluewater.FIA.model.Pilote;
import com.bluewater.FIA.model.Voiture;
import com.bluewater.FIA.service.impl.PiloteServiceImpl;
import com.bluewater.FIA.service.impl.VoitureServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/voiture")
public class VoitureController {
	
	private VoitureServiceImpl voitureServiceImpl;
	private PiloteServiceImpl piloteServiceImpl;
	
	@PostMapping("/{id_pilote}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCarToPilote(@PathVariable("id_pilote") Long id, @RequestBody Voiture voiture) {

		voitureServiceImpl.addCarToPilote(id, voiture);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCar(@RequestBody Voiture voiture) {

		voitureServiceImpl.createCar(voiture);
	}
	
	@GetMapping("")
	public List<Voiture> getAll(){
		return voitureServiceImpl.getAll();
	}
	
	@GetMapping("/{id}")
	public Voiture getById(@PathVariable Long id){
		return voitureServiceImpl.getById(id);
	}
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable Long id) {
		List<Pilote>  pilotes =  piloteServiceImpl.getAll()
				.stream()
				.filter(p -> p.getVoiture().getId() == id)
				.toList();

		
		if(pilotes.size() == 0) {
			voitureServiceImpl.deleteById(id);
		}

		System.out.println("PILOTE SIZE : " + pilotes.size());
	}

}
