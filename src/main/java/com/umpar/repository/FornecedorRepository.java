package com.umpar.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.umpar.domain.Fornecedor;

public interface FornecedorRepository extends MongoRepository<Fornecedor, String>{

	Optional<Fornecedor> findByCnpj(String cnpj);

}
