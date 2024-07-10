package com.umpar.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.umpar.domain.Produto;
import com.umpar.dto.ProdutoRegisterDTO;
import com.umpar.dto.ProdutoResponseDTO;
import com.umpar.exception.CodigoIndisponivelException;
import com.umpar.exception.NotFoundException;
import com.umpar.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public void cadastrar(ProdutoRegisterDTO novoProduto) {
		if (produtoRepository.findByCodigo(novoProduto.codigo()).isPresent()) {
			throw new CodigoIndisponivelException("Codigo de produto cadastrado");
		}
		Produto produto = new Produto(novoProduto);
		produtoRepository.save(produto);
	}

	public ProdutoResponseDTO buscarProduto(String id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Produto não encontrado"));
		return new ProdutoResponseDTO(produto);
	}

	public void alterarDados(String id, ProdutoRegisterDTO novosDadosProduto) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Produto não encontrado"));

		if (!Objects.equals(produto.getCodigo(), novosDadosProduto.codigo())
				&& produtoRepository.findByCodigo(novosDadosProduto.codigo()).isPresent()) {
			throw new CodigoIndisponivelException("Codigo já cadastrado");
		}

		if (novosDadosProduto.nome() != null && !Objects.equals(produto.getNome(), novosDadosProduto.nome())) {
			produto.setNome(novosDadosProduto.nome());
		}

		if (novosDadosProduto.material() != null
				&& !Objects.equals(produto.getMaterial(), novosDadosProduto.material())) {
			produto.setMaterial(novosDadosProduto.material());
		}

		if (novosDadosProduto.marca() != null && !Objects.equals(produto.getMarca(), novosDadosProduto.marca())) {
			produto.setMarca(novosDadosProduto.marca());
		}

		if (novosDadosProduto.cor() != null && !novosDadosProduto.cor().equals(produto.getCor())) {
			produto.setCor(novosDadosProduto.cor());
		}
		if (novosDadosProduto.tamanho() != null && !novosDadosProduto.tamanho().equals(produto.getTamanho())) {
			produto.setTamanho(novosDadosProduto.tamanho());
		}

		if (novosDadosProduto.preco() != null && !novosDadosProduto.preco().equals(produto.getPreco())) {
			produto.setPreco(novosDadosProduto.preco());
		}

		if (novosDadosProduto.data() != null && !novosDadosProduto.data().equals(produto.getData())) {
			produto.setData(novosDadosProduto.data());
		}

		produtoRepository.save(produto);
	}

	public void deletar(String id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Produto não encontrado!"));
		produto.setAtivo(false);
		produtoRepository.save(produto);
	}

}
