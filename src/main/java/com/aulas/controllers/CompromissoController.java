package com.aulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.entities.Compromisso;
import com.aulas.repository.CompromissoRepository;




@RestController
@RequestMapping("/")
public class CompromissoController {
	@Autowired
	CompromissoRepository repo;
	
	@GetMapping("/compromissos/contato/{nome}")
	public ResponseEntity<List<Compromisso>> consultaCompromissoPorNome(@PathVariable("nome") String nome){
		return ResponseEntity.ok(repo.consultaCompromissoPorNomeContato(nome));
	}
	@GetMapping("/compromissos")	
	public ResponseEntity <List<Compromisso>> consultarCompromissos(){
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping("/compromissos")
	public ResponseEntity<Compromisso> salvarCompromisso(@RequestBody Compromisso compromisso){
		return ResponseEntity.ok(repo.save(compromisso));
	}
	
	
}
