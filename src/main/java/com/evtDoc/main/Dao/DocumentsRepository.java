package com.evtDoc.main.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evtDoc.main.entities.Documents;

public interface DocumentsRepository extends JpaRepository<Documents, Long>{

}
