package br.gov.jovemtranquilao.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import br.gov.jovemtranquilao.entidade.Endereco;
import br.gov.jovemtranquilao.entidade.Unidade;
import br.gov.jovemtranquilao.exception.EntityAlreadyExistsException;
import br.gov.jovemtranquilao.exception.EntityDoesNotExistsException;
import br.gov.jovemtranquilao.repository.UnidadeRepository;

@Controller
public class UnidadeBusiness {
	
	@Autowired
	private UnidadeRepository unidadeRepository;

	@Autowired
	private UnidadeRepository enderecoRepository;
	
	public Unidade add(Unidade unidade) throws EntityAlreadyExistsException, EntityDoesNotExistsException {
		
		if(unidadeRepository.findByNomeAndSigla(unidade.getNome(),unidade.getSigla()).isPresent()) {
			throw new EntityAlreadyExistsException(
					unidade.getNome() + " " +
							unidade.getSigla()
					);
		}
		
		verificarSeTodosOsEnderecosExistem(unidade);
		
		return unidadeRepository.save(unidade);
	}

	public Page<Unidade> findAll(Pageable pageable) {
		return unidadeRepository.findAll(pageable);
	}
	
	public Unidade update(Unidade unidade) throws EntityDoesNotExistsException, EntityAlreadyExistsException {
		if(!unidadeRepository.findById(unidade.getUnidId()).isPresent()) {
			throw new EntityDoesNotExistsException(unidade.getUnidId().toString());
		}
		
		Optional<Unidade> unidadeExistente = unidadeRepository.findByNomeAndSigla(
			unidade.getNome(),
			unidade.getSigla()
		);
		
		if(
				unidadeExistente.isPresent() 
				&& 
				!unidadeExistente.get().getUnidId().equals(unidade.getUnidId())
		) {
			throw new EntityAlreadyExistsException(
				unidade.getNome() + " " +
						unidade.getSigla()
				);
		}
		
		verificarSeTodosOsEnderecosExistem(unidade);
		
		return unidadeRepository.save(unidade);
	}

	private void verificarSeTodosOsEnderecosExistem(Unidade unidade) throws EntityDoesNotExistsException {
		for(Endereco endereco : unidade.getEnderecoList()) {
			if(enderecoRepository.findById(
					endereco.getId()
				).isPresent()
			) {
				throw new EntityDoesNotExistsException(
					String.valueOf(endereco.getId())
				);
			}
		}
	}
	
}
