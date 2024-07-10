package com.umpar.dto;

import java.time.LocalDate;

import com.umpar.domain.Produto;

public class ProdutoResponseDTO {
	
	private String codigo;
	private String nome;
	private String material;
	private String marca;
	private String cor;
	private String tamanho;
	private String preco;
	private LocalDate data;
	private boolean ativo;

	public ProdutoResponseDTO() {}
	
	public ProdutoResponseDTO(Produto produto) {
		this.codigo = produto.getCodigo();
		this.nome = produto.getNome();
		this.material = produto.getMaterial();
		this.marca = produto.getMarca();
		this.cor = produto.getCor();
		this.tamanho = produto.getTamanho();
		this.preco = produto.getPreco();
		this.data = produto.getData();
		this.ativo = produto.getAtivo();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	

}
