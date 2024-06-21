package com.bluewater.FIA.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bluewater.FIA.dao.VoitureRepository;
import com.bluewater.FIA.model.Pilote;
import com.bluewater.FIA.model.Voiture;
import com.bluewater.FIA.service.VoitureService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VoitureServiceImpl implements VoitureService {

	private VoitureRepository voitureRepository;
	private PiloteServiceImpl piloteServiceImpl;

	@Override
	public void addCarToPilote(Long id, Voiture voiture) {
		
		Pilote pilote = piloteServiceImpl.getById(id);
		pilote.setVoiture(voiture);
		voitureRepository.save(voiture);

	}

	@Override
	public List<Voiture> getAll() {

		return voitureRepository.findAll();
	}

	@Override
	public void createCar(Voiture voiture) {
		
		voitureRepository.save(voiture);
	}

	@Override
	public void deleteById(Long id) {
		voitureRepository.deleteById(id);
		
	}

	@Override
	public Voiture getById(Long id) {
	    return voitureRepository.findById(id).orElse(null);
	}
	


}
