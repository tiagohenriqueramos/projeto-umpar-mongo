package com.umpar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umpar.dto.ProdutoRegisterDTO;
import com.umpar.dto.ProdutoResponseDTO;
import com.umpar.exception.ApiResponse;
import com.umpar.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<ApiResponse<ProdutoRegisterDTO>> cadastrar(
			@RequestBody @Valid ProdutoRegisterDTO novoProduto) {
		produtoService.cadastrar(novoProduto);
		return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), "Produto cadastrado com sucesso!"));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<ApiResponse<ProdutoResponseDTO>> buscar(@PathVariable @Valid String id) {
		ProdutoResponseDTO produto = produtoService.buscarProduto(id);
		return ResponseEntity.ok()
				.body(new ApiResponse<>(HttpStatus.OK.value(), "Busca realizada com sucesso!", produto));
	}

	@PutMapping("/alterar/{id}")
	public ResponseEntity<ApiResponse<?>> alterarDados(@PathVariable @Valid String id,
			@RequestBody @Valid ProdutoRegisterDTO novosDadosProduto) {
		produtoService.alterarDados(id, novosDadosProduto);
		return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), "Dados alterados com sucesso!"));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<?>> deletar(@PathVariable @Valid String id) {
		produtoService.deletar(id);
		return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(),"Produto deletado com sucesso!"));
	}

}
