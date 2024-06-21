package com.bluewater.FIA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bluewater.FIA.dao.PiloteRepository;
import com.bluewater.FIA.dao.VoitureRepository;
import com.bluewater.FIA.model.Pilote;
import com.bluewater.FIA.model.Voiture;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;


public interface PiloteService {
	
	public List<Pilote> getAll();
	public Long createPilote(Pilote pilote);
	public Pilote getById(Long id);
	public void deleteById(Long id);

}
