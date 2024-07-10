package com.umpar.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.umpar.domain.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
	Optional<Produto> findByCodigo(String codigo);
}