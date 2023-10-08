package br.gov.jovemtranquilao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.jovemtranquilao.entidade.Unidade;

public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

	public Optional<Unidade> findByNomeAndSigla(String nome, String sigla);

}
