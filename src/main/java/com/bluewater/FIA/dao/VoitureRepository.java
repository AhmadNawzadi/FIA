package com.bluewater.FIA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluewater.FIA.model.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
