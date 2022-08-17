package com.aulas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.entities.Contato;
import com.aulas.repository.ContatoRepository;
import com.aulas.service.exceptions.ValidacaoException;
import com.aulas.service.dto.ContatoDTO;
import com.aulas.service.exceptions.OperacaoNaoPermitidaException;

@Service

public class ContatoService {

	@Autowired
	ContatoRepository repo;
	
	public ContatoDTO salvar(Contato contato) {
	/*	if(contato.getFone().length() != 14) {
			throw new ValidacaoException("telefone inválido");
		}
		String email = contato.getEmail();
		if(!email.contains("@")) {
			throw new ValidacaoException("email inválido");
		}*/
		Contato ct = repo.save(contato);
		ContatoDTO ctDto = new ContatoDTO(ct);
		return ctDto;
	}
	
	public List<ContatoDTO> consultarContatos(){
		List<Contato> contatos = repo.findAll();
		List<ContatoDTO> contatosDTO = new ArrayList<>();
		for (Contato ct: contatos) {
			ContatoDTO ctDTO = new ContatoDTO(ct);
			contatosDTO.add(ctDTO);
		}
		return contatosDTO;
	}
	
	public ContatoDTO consultarUmContato(Long idcontato) {
		Optional<Contato> opContato = repo.findById(idcontato);
		Contato contato = opContato.orElseThrow(( )-> new EntityNotFoundException("Contato não encontrado"));
		return new ContatoDTO(contato);
	}
	
	public Contato consultarContato(Long idcontato) {
		Optional<Contato> opContato = repo.findById(idcontato);
		Contato contato = opContato.orElseThrow(( )-> new EntityNotFoundException("Contato não encontrado"));
		return contato;
	}
	
	public void excluirContato (Long idcontato){
		Contato contato = consultarContato(idcontato);
		//repo.deleteById(idcontato);
		 repo.delete(contato);
//		Optional<Contato> opContato = repo.findById(idContato);
//		Contato contato = opContato.orElseThrow(( )-> new MinhaExcecao("Contato não existe não"));
//		return contato;
	}
	
	public ContatoDTO alterarContato(Long idcontato, Contato contato) {
		Contato ct = consultarContato(idcontato);
		BeanUtils.copyProperties(contato, ct, "id");
		/*Contato ct = repo.findById(idcontato).get();
		ct.setEmail(contato.getEmail());
		ct.setNome(contato.getNome());
		ct.setFone(contato.getFone());*/
		
		return new ContatoDTO(repo.save(ct));
	}
	
	public List<ContatoDTO> consultarContatoPorEmail(String email){
		return ContatoDTO.converteParaDTO(repo.findByEmail(email));
	}
}

