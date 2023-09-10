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

import br.gov.jovemtranquilao.business.EnderecoBusiness;
import br.gov.jovemtranquilao.entidade.Endereco;
import br.gov.jovemtranquilao.exception.EntityAlreadyExistsException;
import br.gov.jovemtranquilao.exception.EntityDoesNotExistsException;

@RestController()
@RequestMapping("/endereco")
public class EnderecoController {
	
	
	@Autowired
	private EnderecoBusiness enderecoBusiness;
	
	@GetMapping
	public Page<Endereco> get(Pageable pageable) {
		return enderecoBusiness.findAll(pageable);
	}
	
	@PostMapping
	public Endereco post(
		@RequestBody Endereco endereco
	) throws EntityAlreadyExistsException {
		return enderecoBusiness.add(endereco);
	}
	
	@PutMapping
	public Endereco put(
		@RequestBody Endereco endereco
	) throws EntityAlreadyExistsException, EntityDoesNotExistsException {
		return enderecoBusiness.update(endereco);
	}
	
}
