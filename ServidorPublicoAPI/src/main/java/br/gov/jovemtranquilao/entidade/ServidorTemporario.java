package br.gov.jovemtranquilao.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServidorTemporario {
	@Id
	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pesId;

	@Column(name = "st_data_admissao")
	private Date dataAdmissao;

	@Column(name = "st_data_demissao")
	private Date dataDemissao;

}
