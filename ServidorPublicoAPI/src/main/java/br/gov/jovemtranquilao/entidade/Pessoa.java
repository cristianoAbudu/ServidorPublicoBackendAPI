package br.gov.jovemtranquilao.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@Column(name = "pes_id")
	private Integer id;

	@Column(name = "pes_nome")
	private String nome;

	@Column(name = "pes_data_nascimento")
	private Date dataNascimento;

	@Column(name = "pes_sexo")
	private String sexo;

	@Column(name = "pes_mae")
	private String mae;

	@Column(name = "pes_pai")
	private String pai;

}
