package com.umpar.exception;

public class CodigoIndisponivelException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CodigoIndisponivelException(String mensagem) {
		super(mensagem);
	}

}
