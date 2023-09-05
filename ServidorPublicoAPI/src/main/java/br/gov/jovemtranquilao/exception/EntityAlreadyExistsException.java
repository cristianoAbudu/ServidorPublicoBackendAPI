package br.gov.jovemtranquilao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public EntityAlreadyExistsException(String nome) {
		super(nome);
	}


}
