package br.gov.jovemtranquilao.entidade;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Cidade {
	@Id
	@GeneratedValue
	@Column(name = "cid_id")
	private Integer id;

	@Column(name = "cid_nome")
	private String nome;

	@Column(name = "cid_uf")
	private String uf;

	@JsonIgnore
	@OneToMany(
		cascade = CascadeType.ALL, 
		orphanRemoval = true, 
		fetch = FetchType.LAZY
	)
	@JoinColumn(name = "cid_id")
	private List<Endereco> enderecoList;
	
}
