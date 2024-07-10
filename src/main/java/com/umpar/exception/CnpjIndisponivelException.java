package com.umpar.exception;

public class CnpjIndisponivelException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CnpjIndisponivelException(String mensagem) {
		super(mensagem);
	}
}
