package com.umpar.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.umpar.dto.FornecedorRegisterDTO;

@Document
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String razaoSocial;
    @Indexed(unique = true)
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
	
	public Fornecedor(){}

	public Fornecedor(String id, String razaoSocial, String cnpj, String ruaAvenida, String numero, String bairro,
			String cidade, String estado, String telefone, String email, String site, boolean ativo, Produto produto) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.ruaAvenida = ruaAvenida;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.email = email;
		this.site = site;
		this.ativo = ativo;
		this.produto = produto;
	}
	
	public Fornecedor(FornecedorRegisterDTO novoFornecedor) {
		this.razaoSocial = novoFornecedor.razaoSocial();
		this.cnpj = novoFornecedor.cnpj();
		this.ruaAvenida = novoFornecedor.ruaAvenida();
		this.numero = novoFornecedor.numero();
		this.bairro = novoFornecedor.bairro();
		this.cidade = novoFornecedor.cidade();
		this.estado = novoFornecedor.estado();
		this.telefone = novoFornecedor.telefone();
		this.email = novoFornecedor.email();
		this.site = novoFornecedor.site();
		this.ativo = novoFornecedor.ativo();
		this.produto = novoFornecedor.produto();
	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	@Override
	public int hashCode() {
		return Objects.hash(cnpj, id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id);
	}

	
	

}
