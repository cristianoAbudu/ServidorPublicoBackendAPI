package br.gov.jovemtranquilao.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ServidorTemporario {
	@Id
	@Column(name = "pes_id")
	private Integer pesId;

	@Column(name = "st_data_admissao")
	private Date dataAdmissao;

	@Column(name = "st_data_demissao")
	private Date dataDemissao;

}
