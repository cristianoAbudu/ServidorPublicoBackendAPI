package br.gov.jovemtranquilao.entidade;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Endereco {
	@Id
	@GeneratedValue
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

	@ManyToMany
	@JoinTable(name = "pessoa_endereco", joinColumns = @JoinColumn(name = "end_id"), inverseJoinColumns = @JoinColumn(name = "pes_id"))
	private List<Pessoa> pessoaList;

	@ManyToMany
	@JoinTable(name = "unidade_endereco", joinColumns = @JoinColumn(name = "end_id"), inverseJoinColumns = @JoinColumn(name = "unid_id"))
	private List<Unidade> unidadeList;
}
