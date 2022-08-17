package com.aulas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CompromissoController {
	@GetMapping("/compromisso")
	
	public String ola() {
		return "Oi";
	}

}
