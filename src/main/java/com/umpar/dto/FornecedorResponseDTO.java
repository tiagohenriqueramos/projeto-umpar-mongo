package com.umpar.dto;

import com.umpar.domain.Fornecedor;
import com.umpar.domain.Produto;

public class FornecedorResponseDTO {

	private String razaoSocial;
	private String cnpj;
	private String ruaAvenida;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	private String email;
	private String site;
	private boolean ativo;
	private Produto produto;

	public FornecedorResponseDTO() {
	}

	public FornecedorResponseDTO(Fornecedor fornecedor) {
		this.razaoSocial = fornecedor.getRazaoSocial();
		this.cnpj = fornecedor.getCnpj();
		this.ruaAvenida = fornecedor.getRuaAvenida();
		this.numero = fornecedor.getNumero();
		this.bairro = fornecedor.getBairro();
		this.cidade = fornecedor.getCidade();
		this.estado = fornecedor.getEstado();
		this.telefone = fornecedor.getTelefone();
		this.email = fornecedor.getEmail();
		this.site = fornecedor.getSite();
		this.ativo = fornecedor.getAtivo();
		this.produto = fornecedor.getProduto();
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRuaAvenida() {
		return ruaAvenida;
	}

	public void setRuaAvenida(String ruaAvenida) {
		this.ruaAvenida = ruaAvenida;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
