package com.umpar.exception;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class ApiResponse<T> implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private int status;
	private String mensagem;
	private Instant timestamp;
	private T objeto;
	
	public ApiResponse() {}

	public ApiResponse(int status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
		this.timestamp = Instant.now();
	}
	
	public ApiResponse(int status, T objeto) {
		this.status = status;
		this.objeto = objeto;
		this.timestamp = Instant.now();
	}
	
	public ApiResponse(int status, String mensagem, T objeto) {
		this.status = status;
		this.mensagem = mensagem;
		this.timestamp = Instant.now();
		this.objeto = objeto;
	}
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
	
}
