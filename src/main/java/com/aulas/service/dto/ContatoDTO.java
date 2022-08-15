package com.aulas.service.dto;

import com.aulas.entities.Contato;

public class ContatoDTO {

	private Long id;
	private String nome;
	private String email;
	private String fone;
	
	public ContatoDTO() { }
	
	public ContatoDTO(Long id, String nome, String email, String fone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
	}
	
	public ContatoDTO(Contato contato) {
		this.id = contato.getId();
		this.nome = contato.getNome();
		this.email = contato.getEmail();
		this.fone = contato.getFone();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
}
