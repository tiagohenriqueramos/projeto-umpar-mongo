package com.umpar.dto;

import java.time.LocalDate;

public record ProdutoRegisterDTO (String codigo, String nome, String material, String marca, String cor, String tamanho, String preco, LocalDate data, boolean ativo ) {}
