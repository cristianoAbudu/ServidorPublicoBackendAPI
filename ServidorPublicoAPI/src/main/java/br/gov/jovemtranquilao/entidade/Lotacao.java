package br.gov.jovemtranquilao.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Lotacao {
	@Id
	@Column(name = "lot_id")
	private Integer lotId;

	@Column(name = "pes_id")
	private Integer pesId;

	@Column(name = "unid_id")
	private Integer unidId;

	@Column(name = "lot_data_lotacao")
	private Date dataLotacao;

	@Column(name = "lot_data_remocao")
	private Date dataRemocao;

	@Column(name = "portaria")
	private String matricula;

}
