package br.gov.jovemtranquilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.jovemtranquilao.business.CidadeBusiness;
import br.gov.jovemtranquilao.entidade.Cidade;
import br.gov.jovemtranquilao.exception.EntityAlreadyExistsException;
import br.gov.jovemtranquilao.exception.EntityDoesNotExistsException;

@RestController()
@RequestMapping("/cidade")
public class CidadeController {
	
	
	@Autowired
	private CidadeBusiness cidadeBusiness;
	
	@GetMapping
	public List<Cidade> get() {
		return cidadeBusiness.findAll();
	}
	
	@PostMapping
	public Cidade post(
		@RequestBody Cidade cidade
	) throws EntityAlreadyExistsException {
		return cidadeBusiness.add(cidade);
	}
	
	@PutMapping
	public Cidade put(
		@RequestBody Cidade cidade
	) throws EntityAlreadyExistsException, EntityDoesNotExistsException {
		return cidadeBusiness.update(cidade);
	}
	
}
