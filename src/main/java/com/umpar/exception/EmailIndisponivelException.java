package com.umpar.exception;

public class EmailIndisponivelException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmailIndisponivelException(String mensagem) {
		super(mensagem);
	}
}
