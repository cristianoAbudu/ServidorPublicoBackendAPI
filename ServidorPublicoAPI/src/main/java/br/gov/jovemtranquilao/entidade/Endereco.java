package br.gov.jovemtranquilao.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco {
	@Id
	@Column(name = "end_id")
	private Integer id;

	@Column(name = "end_tipo_logradouro")
	private String tipoLogradouro;

	@Column(name = "end_logradouro")
	private String logradouro;

	@Column(name = "end_numero")
	private String numero;

	@Column(name = "end_bairro")
	private String bairro;

	@ManyToOne
	@JoinColumn(name = "cid_id")
	private Cidade cidade;

}
