package com.evtDoc.main.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evtDoc.main.entities.Seances;

public interface SeancesRepository extends JpaRepository<Seances, Long> {

}
