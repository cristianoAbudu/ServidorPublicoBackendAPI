package br.gov.jovemtranquilao.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ServidorEfetivo {
	@Id
	@Column(name = "pes_id")
	private Integer pesId;

	@Column(name = "se_matricula")
	private String matricula;

}
