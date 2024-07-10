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

import com.umpar.dto.FornecedorRegisterDTO;
import com.umpar.dto.FornecedorResponseDTO;
import com.umpar.exception.ApiResponse;
import com.umpar.service.FornecedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

	private final FornecedorService fornecedorService;

	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<ApiResponse<FornecedorRegisterDTO>> cadastrar(
			@RequestBody @Valid FornecedorRegisterDTO novoFornecedor) {
		fornecedorService.cadastrar(novoFornecedor);
		return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), "Produto cadastrado com sucesso!"));
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<ApiResponse<FornecedorResponseDTO>> buscar(@PathVariable @Valid String id) {
		FornecedorResponseDTO fornecedor = fornecedorService.buscarProduto(id);
		return ResponseEntity.ok()
				.body(new ApiResponse<>(HttpStatus.OK.value(), "Busca realizada com sucesso!", fornecedor));
	}

	@PutMapping("/alterar/{id}")
	public ResponseEntity<ApiResponse<?>> alterarDados(@PathVariable @Valid String id,
			@RequestBody @Valid FornecedorRegisterDTO novosDadosFornecedor) {
		fornecedorService.alterarDados(id, novosDadosFornecedor);
		return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), "Dados alterados com sucesso!"));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<?>> deletar(@PathVariable @Valid String id) {
		fornecedorService.deletar(id);
		return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(),"Produto deletado com sucesso!"));
	}

}
