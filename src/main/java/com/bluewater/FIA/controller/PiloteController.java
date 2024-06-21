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
import com.bluewater.FIA.service.impl.PiloteServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pilote")
public class PiloteController {

	private PiloteServiceImpl psi;
	
	@GetMapping("")
	public List<Pilote> getAll(){
		return psi.getAll();
	}
	
	@GetMapping("/{id}")
	public Pilote getById(@PathVariable Long id){
		return psi.getById(id);
	}
	
	@PostMapping("")
	public Long createPilote(@RequestBody Pilote pilote) {
		return psi.createPilote(pilote);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deletePilote(@PathVariable Long id) {
		psi.deleteById(id);
	}
	

}
