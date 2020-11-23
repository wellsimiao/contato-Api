package br.com.ultracon.contatoapi.controller.dto;

import br.com.ultracon.contatoapi.model.Contato;
import io.swagger.annotations.ApiModelProperty;

public class ContatoDTO {

	@ApiModelProperty(example = "123", value = "")
	private Long id;

	@ApiModelProperty(example = "wellington", value = "")
	private String nome;

	@ApiModelProperty(example = "99999999999", value = "")
	private String cpf;

	@ApiModelProperty(example = "99999999999999", value = "")
	private String cnpj;

	public ContatoDTO(Contato contato) {
		this.id = contato.getId();
		this.nome = contato.getNome();
		this.cpf = contato.getCpf();
		this.cnpj = contato.getCnpj();
	}

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
}
