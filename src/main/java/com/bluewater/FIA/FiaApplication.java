package com.bluewater.FIA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bluewater.FIA.model.Pilote;
import com.bluewater.FIA.model.Voiture;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class FiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiaApplication.class, args);
	}
	


}
