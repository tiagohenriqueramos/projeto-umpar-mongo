package com.umpar.dto;

import com.umpar.domain.Produto;

public record FornecedorRegisterDTO (String razaoSocial, String cnpj, String ruaAvenida, String numero, String bairro, String cidade, String estado, String telefone, String email, String site, boolean ativo, Produto produto ) {}
