package br.gov.jovemtranquilao.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FotoPessoa {
	@Id
	@Column(name = "fp_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pesId;

	@Column(name = "fp_data")
	private Date data;

	@Column(name = "fp_bucket")
	private String bucket;

	@Column(name = "fp_hash")
	private String hash;


}
