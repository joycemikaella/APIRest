package com.aulas.controllers.exception;

import java.time.Instant;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aulas.service.exceptions.ValidacaoException;
import com.aulas.service.exceptions.OperacaoNaoPermitidaException;

@ControllerAdvice
public class ManipuladorErros {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(EntityNotFoundException e, HttpServletRequest req){
		ErroPadrao erro = new ErroPadrao();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setMessage("Recurso não encontrado");
		erro.setPath(req.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(OperacaoNaoPermitidaException.class)
	public ResponseEntity<ErroPadrao> minhaExcecao(OperacaoNaoPermitidaException e, HttpServletRequest req){
		ErroPadrao erro = new ErroPadrao();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
		erro.setError("Sem conteúdo");
		erro.setMessage(e.getMessage());
		erro.setPath(req.getRequestURI());
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(erro);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErroPadrao> minhaExcecao(EmptyResultDataAccessException e, HttpServletRequest req){
		ErroPadrao erro = new ErroPadrao();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setError("Sem conteúdo");
		erro.setMessage(e.getMessage());
		erro.setPath(req.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	
	@ExceptionHandler(ValidacaoException.class)
	public ResponseEntity<ErroValidacao> minhaExcecao(ValidacaoException e, HttpServletRequest req){
		ErroValidacao erro = new ErroValidacao();
		erro.setTimestamp(Instant.now());
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
