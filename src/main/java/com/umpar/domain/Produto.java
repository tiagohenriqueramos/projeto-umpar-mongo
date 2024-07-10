package com.umpar.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.umpar.dto.ProdutoRegisterDTO;

@Document
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String codigo;
	private String nome;
	private String material;
	private String marca;
	private String cor;
	private String tamanho;
	private String preco;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	private boolean ativo;

	
	public Produto() {
		
	}	

	public Produto(String id, String codigo, String nome, String material, String marca, String cor, String tamanho,
			String preco, LocalDate data, boolean ativo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.material = material;
		this.marca = marca;
		this.cor = cor;
		this.tamanho = tamanho;
		this.preco = preco;
		this.data = data;
		this.ativo = ativo;
	}
	
	public Produto(ProdutoRegisterDTO novoProduto) {
		this.codigo = novoProduto.codigo();
		this.nome = novoProduto.nome();
		this.material = novoProduto.material();
		this.marca = novoProduto.marca();
		this.cor = novoProduto.cor();
		this.tamanho = novoProduto.tamanho();
		this.preco = novoProduto.preco();
		this.data = novoProduto.data();
		this.ativo = novoProduto.ativo();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
}
