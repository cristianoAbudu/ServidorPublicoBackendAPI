package br.gov.jovemtranquilao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.jovemtranquilao.entidade.Cidade;
import br.gov.jovemtranquilao.entidade.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	public Optional<Endereco> findByCidadeAndBairroAndTipoLogradouroAndLogradouroAndNumero(
			Cidade cidade, 
			String bairro,
			String tipoLogradouro, 
			String logradouro,			
			String numero
	);

}
