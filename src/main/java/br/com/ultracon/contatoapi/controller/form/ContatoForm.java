package br.com.ultracon.contatoapi.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.ultracon.contatoapi.model.Contato;
import br.com.ultracon.contatoapi.repository.ContatoRepository;
import io.swagger.annotations.ApiModelProperty;



public class ContatoForm {
	@ApiModelProperty(example = "wellington", value = "")
	@NotNull
	@NotEmpty
	private String nome;
	
	@ApiModelProperty(example = "99999999", value = "")
	@NotNull @NotEmpty
	private String cpf;
	
	@ApiModelProperty(example = "9999999999999", value = "")
	@NotNull @NotEmpty
	private String cnpj;

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
	
	public Contato atualizar(Long id, ContatoRepository contatoRepository) {
		
		Contato contato = contatoRepository.getOne(id);
		contato.setNome(this.nome);
		contato.setCpf(this.cpf);
		contato.setCnpj(this.cnpj);
		if (contato !=null) {
			contato.setNome(nome);
			
		}
		
		return contato;
		
	}

	public Contato converter(ContatoRepository contatoRepository, Long id) {

		Contato contato = contatoRepository.getOne(id);
		contato.setNome(this.nome);
				
		return contato;
	}

	public Contato converter(ContatoRepository contatoRepository) {
		// TODO Auto-generated method stub
		return null;
	}

}
