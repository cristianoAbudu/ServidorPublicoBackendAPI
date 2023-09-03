package br.gov.jovemtranquilao.entidade;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Unidade {
	@Id
	@Column(name = "unid_id")
	private Integer unidId;

	@Column(name = "unid_nome")
	private String nome;

	@Column(name = "unid_sigla")
	private String sigla;

	@OneToMany
	@JoinColumn(name = "unid_id")
	private List<Lotacao> lotacaoList;

	@ManyToMany
	@JoinTable(name = "unidade_endereco", joinColumns = @JoinColumn(name = "unid_id"), inverseJoinColumns = @JoinColumn(name = "end_id"))
	private List<Endereco> enderecoList;

}
