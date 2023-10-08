package br.gov.jovemtranquilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.jovemtranquilao.business.UnidadeBusiness;
import br.gov.jovemtranquilao.entidade.Unidade;
import br.gov.jovemtranquilao.exception.EntityAlreadyExistsException;
import br.gov.jovemtranquilao.exception.EntityDoesNotExistsException;

@RestController()
@RequestMapping("/unidade")
public class UnidadeController {
	
	
	@Autowired
	private UnidadeBusiness unidadeBusiness;
	
	@GetMapping
	public Page<Unidade> get(Pageable pageable) {
		return unidadeBusiness.findAll(pageable);
	}
	
	@PostMapping
	public Unidade post(
		@RequestBody Unidade unidade
	) throws EntityAlreadyExistsException, EntityDoesNotExistsException {
		return unidadeBusiness.add(unidade);
	}
	
	@PutMapping
	public Unidade put(
		@RequestBody Unidade unidade
	) throws EntityAlreadyExistsException, EntityDoesNotExistsException {
		return unidadeBusiness.update(unidade);
	}
	
}
