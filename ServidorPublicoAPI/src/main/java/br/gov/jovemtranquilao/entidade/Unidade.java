package br.gov.jovemtranquilao.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Unidade {
	@Id
	@Column(name = "unid_id")
	private Integer unidId;

	@Column(name = "unid_nome")
	private String nome;

	@Column(name = "unid_sigla")
	private String sigla;

}
