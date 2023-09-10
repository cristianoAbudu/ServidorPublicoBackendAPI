package br.gov.jovemtranquilao.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import br.gov.jovemtranquilao.entidade.Endereco;
import br.gov.jovemtranquilao.exception.EntityAlreadyExistsException;
import br.gov.jovemtranquilao.exception.EntityDoesNotExistsException;
import br.gov.jovemtranquilao.repository.EnderecoRepository;

@Controller
public class EnderecoBusiness {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco add(Endereco endereco) throws EntityAlreadyExistsException {
		if(enderecoRepository.findByCidadeAndBairroAndTipoLogradouroAndLogradouroAndNumero(
				endereco.getCidade(), 
				endereco.getBairro(),
				endereco.getTipoLogradouro(),
				endereco.getLogradouro(),
				endereco.getNumero()
			).isPresent()
		) {
			throw new EntityAlreadyExistsException(
				endereco.getCidade() + " " +
				endereco.getBairro() + " " +
				endereco.getTipoLogradouro() + " " +
				endereco.getLogradouro()
			);
		}
		return enderecoRepository.save(endereco);
	}

	public Page<Endereco> findAll(Pageable pageable) {
		return enderecoRepository.findAll(pageable);
	}
	
	public Endereco update(Endereco endereco) throws EntityDoesNotExistsException, EntityAlreadyExistsException {
		if(!enderecoRepository.findById(endereco.getId()).isPresent()) {
			throw new EntityDoesNotExistsException(endereco.getId().toString());
		}
		if(enderecoRepository.findByCidadeAndBairroAndTipoLogradouroAndLogradouroAndNumero(
				endereco.getCidade(), 
				endereco.getBairro(),
				endereco.getTipoLogradouro(),
				endereco.getLogradouro(),
				endereco.getNumero()
			).isPresent()
		) {
			throw new EntityAlreadyExistsException(
				endereco.getCidade() + " " +
				endereco.getBairro() + " " +
				endereco.getTipoLogradouro() + " " +
				endereco.getLogradouro()
			);
		}
		return enderecoRepository.save(endereco);
	}
	
}
