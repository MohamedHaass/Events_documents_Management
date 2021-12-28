package com.evtDoc.main.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evtDoc.main.entities.Evenements;

public interface EvenementsRepository extends JpaRepository<Evenements, Long> {

}
