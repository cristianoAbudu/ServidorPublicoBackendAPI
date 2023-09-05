package br.gov.jovemtranquilao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.jovemtranquilao.entidade.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	public Optional<Cidade> findByNome(String nome);

	public Optional<Cidade> findByNomeAndUf(String nome, String uf);

}
