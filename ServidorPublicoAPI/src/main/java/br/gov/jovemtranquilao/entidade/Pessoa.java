package br.gov.jovemtranquilao.entidade;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

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

	@ManyToMany
	@JoinTable(name = "pessoa_endereco", joinColumns = @JoinColumn(name = "pes_id"), inverseJoinColumns = @JoinColumn(name = "end_id"))
	private List<Endereco> enderecoList;

	@OneToMany
	@JoinColumn(name = "pes_id")
	private List<FotoPessoa> fotoList;

	@OneToMany
	@JoinColumn(name = "pes_id")
	private List<ServidorTemporario> servidorTemporarioList;

	@OneToMany
	@JoinColumn(name = "pes_id")
	private List<ServidorEfetivo> servidorEfetivoList;

	@OneToMany
	@JoinColumn(name = "pes_id")
	private List<Lotacao> lotacaoList;

}
