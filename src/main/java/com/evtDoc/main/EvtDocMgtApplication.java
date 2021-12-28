package com.evtDoc.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.evtDoc.main.Dao.EvenementsRepository;
import com.evtDoc.main.Dao.SallesRepository;
import com.evtDoc.main.Dao.SeancesRepository;
import com.evtDoc.main.entities.Evenements;
import com.evtDoc.main.entities.Salles;
import com.evtDoc.main.entities.Seances;


@SpringBootApplication

public class EvtDocMgtApplication implements CommandLineRunner {
	
	@Autowired
	private SallesRepository sallesRepository;
	
	@Autowired
	private SeancesRepository seancesRepository;
	
	@Autowired
	private EvenementsRepository evenementsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EvtDocMgtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Stream.of("SALLE CONFERENCE","SALLE PRINCIPACE","SALLE 1")
					.forEach(s->{
						Salles sle = new Salles(null,
								s,
								5 + (int) Math.round(Math.random()*10),
								 null);
						
						sallesRepository.save(sle);		
					});
		
		Stream.of("31/12/2018;08-10",
				"31/12/2019;10-12",
				"31/12/2020;14-16",
				"31/12/2021;16-18").forEach(s->{
					
					List<Salles> salles = new ArrayList<Salles>();
					salles = sallesRepository.findAll();
				Seances sce = new Seances(null,
						new Date(),
						s.split(";")[1],
						null,
						salles.get(0));
				
				seancesRepository.save(sce);
				
			
		});
		
		Stream.of("Journée Doctorale",
				"Marche Verte",
				"Fête d'indépendance")
					.forEach(ev->{
						
						List<Seances> scesStored = seancesRepository.findAll();
						List<Seances> scesAssoc = new ArrayList<>();
						scesAssoc.add(scesStored.get(0));
						Evenements evt = new Evenements(null,
								ev,
								"FSTS",
								"organisation-evenement-entreprise-735x400.png",
								"TEST TEST...",
								"lancé",
								null,
								null,
								null
								);
						
						evt.setSeances(scesAssoc);
						
						evenementsRepository.save(evt);
					});
		
	}

}
