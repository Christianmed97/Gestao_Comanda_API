package br.edu.infnet.gestaocomanda.model.vo;

import br.edu.infnet.gestaocomanda.exception.EmailInvalidoException;

public class EmailVO {
	
	private String enderecoEmail;
	
	private EmailVO(String enderecoEmail) throws EmailInvalidoException {
		if (validaEmail(enderecoEmail)) {
			this.enderecoEmail = enderecoEmail;
		} 
		throw new EmailInvalidoException();
		
	}
	
	private boolean validaEmail(String enderecoEmail) {
		return true; 
	}

}
