package com.bluewater.FIA.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.bluewater.FIA.dao.PiloteRepository;
import com.bluewater.FIA.dao.VoitureRepository;
import com.bluewater.FIA.exception.EntityNotFoundException;
import com.bluewater.FIA.model.Pilote;
import com.bluewater.FIA.model.Voiture;
import com.bluewater.FIA.service.PiloteService;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PiloteServiceImpl implements PiloteService {
	
	private PiloteRepository piloteRepository;
	private VoitureRepository voitureRepository;
	
//	@PostConstruct
//	private void postConstructor() {
//		Voiture voiture1 = new Voiture("Audi", 50);
//		Voiture voiture2 = new Voiture("Audi", 50);
//		Pilote pilote1 = new Pilote("Ahmad", voiture1);
//		Pilote pilote2 = new Pilote("Zia", voiture2);
//		
//		voitureRepository.save(voiture1);
//		voitureRepository.save(voiture2);
//		piloteRepository.save(pilote1);
//		piloteRepository.save(pilote2);
//	}

	List<Pilote> pilotes;
	
	@Override
	public List<Pilote> getAll() {
		pilotes = piloteRepository.findAll();
		return pilotes;
	}

	@Override
	public Long createPilote(Pilote pilote) {
		//voitureRepository.save(pilote.getVoiture());
		return piloteRepository.save(pilote).getId();
	}

	@Override
	public Pilote getById(Long id) {
		Optional<Pilote> pilote = piloteRepository.findById(id);
		
		if(pilote == null) {
			throw new EntityNotFoundException();
		}
		return pilote.get();
	}

	@Override
	public void deleteById(Long id) {
		getById(id);
		piloteRepository.deleteById(id);
		
	}

}
