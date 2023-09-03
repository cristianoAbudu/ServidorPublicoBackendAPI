package br.gov.jovemtranquilao.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServidorEfetivo {
	@Id
	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pesId;

	@Column(name = "se_matricula")
	private String matricula;

}
