package com.aulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.entities.Contato;

@Repository
public interface ContatoRepository extends JpaRepository <Contato, Long> {
	
}