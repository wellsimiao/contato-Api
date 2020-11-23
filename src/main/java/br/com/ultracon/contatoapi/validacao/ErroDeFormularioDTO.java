package br.com.ultracon.contatoapi.validacao;

public class ErroDeFormularioDTO {

	private String campo;
	private String erro;

	ErroDeFormularioDTO(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
