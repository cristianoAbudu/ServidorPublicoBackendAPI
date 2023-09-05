package br.gov.jovemtranquilao.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.gov.jovemtranquilao.entidade.Cidade;
import br.gov.jovemtranquilao.exception.EntityAlreadyExistsException;
import br.gov.jovemtranquilao.exception.EntityDoesNotExistsException;
import br.gov.jovemtranquilao.repository.CidadeRepository;

@Controller
public class CidadeBusiness {
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade add(Cidade cidade) throws EntityAlreadyExistsException {
		if(cidadeRepository.findByNomeAndUf(cidade.getNome(), cidade.getUf()).isPresent()) {
			throw new EntityAlreadyExistsException(cidade.getUf() + " "+cidade.getNome());
		}
		return cidadeRepository.save(cidade);
	}

	public List<Cidade> findAll() {
		return cidadeRepository.findAll();
	}
	
	public Cidade update(Cidade cidade) throws EntityDoesNotExistsException, EntityAlreadyExistsException {
		if(!cidadeRepository.findById(cidade.getId()).isPresent()) {
			throw new EntityDoesNotExistsException(cidade.getId().toString());
		}
		if(cidadeRepository.findByNomeAndUf(cidade.getNome(), cidade.getUf()).isPresent()) {
			throw new EntityAlreadyExistsException(cidade.getUf() + " "+cidade.getNome());
		}
		return cidadeRepository.save(cidade);
	}
	
}
