package br.gov.jovemtranquilao.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lotacao {
	@Id
	@Column(name = "lot_id")
	private Integer lotId;

	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pesId;

	@ManyToOne
	@JoinColumn(name = "unid_id")
	private Unidade unidId;

	@Column(name = "lot_data_lotacao")
	private Date dataLotacao;

	@Column(name = "lot_data_remocao")
	private Date dataRemocao;

	@Column(name = "portaria")
	private String matricula;


}
