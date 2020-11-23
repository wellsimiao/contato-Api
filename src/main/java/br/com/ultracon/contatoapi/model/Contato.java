package br.com.ultracon.contatoapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String nome;
	private String cpf;
	private String cnpj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Contato (Long id, String nome, String cpf, String cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
	}

}
