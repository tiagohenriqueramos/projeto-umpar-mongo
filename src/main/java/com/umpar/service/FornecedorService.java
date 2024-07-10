package com.umpar.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.umpar.domain.Fornecedor;
import com.umpar.dto.FornecedorRegisterDTO;
import com.umpar.dto.FornecedorResponseDTO;
import com.umpar.exception.CnpjIndisponivelException;
import com.umpar.exception.NotFoundException;
import com.umpar.repository.FornecedorRepository;

import jakarta.validation.Valid;

@Service
public class FornecedorService {

	private final FornecedorRepository fornecedorRepository;

	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	public void cadastrar(@Valid FornecedorRegisterDTO novoFornecedor) {
		if (fornecedorRepository.findByCnpj(novoFornecedor.cnpj()).isPresent()) {
			throw new CnpjIndisponivelException("CNPJ do fornecedor cadastrado");
		}
		Fornecedor fornecedor = new Fornecedor(novoFornecedor);
		fornecedorRepository.save(fornecedor);
	}

	public FornecedorResponseDTO buscarProduto(@Valid String id) {
		Fornecedor fornecedor = fornecedorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Fornecedor não encontrado"));
		return new FornecedorResponseDTO(fornecedor);
	}

	public void alterarDados(@Valid String id, @Valid FornecedorRegisterDTO novosDadosFornecedor) {
		Fornecedor fornecedor = fornecedorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Produto não encontrado"));

		if (!Objects.equals(fornecedor.getCnpj(), novosDadosFornecedor.cnpj())
				&& fornecedorRepository.findByCnpj(novosDadosFornecedor.cnpj()).isPresent()) {
			throw new CnpjIndisponivelException("CNPJ já cadastrado");
		}
		
		if (novosDadosFornecedor.razaoSocial() != null && !Objects.equals(fornecedor.getRazaoSocial(), novosDadosFornecedor.razaoSocial())) {
			fornecedor.setRazaoSocial(novosDadosFornecedor.razaoSocial());
		}

		if (novosDadosFornecedor.ruaAvenida() != null
				&& !Objects.equals(fornecedor.getRuaAvenida(), novosDadosFornecedor.ruaAvenida())) {
			fornecedor.setRuaAvenida(novosDadosFornecedor.ruaAvenida());
		}

		if (novosDadosFornecedor.numero() != null && !Objects.equals(fornecedor.getNumero(), novosDadosFornecedor.numero())) {
			fornecedor.setNumero(novosDadosFornecedor.numero());
		}

		if (novosDadosFornecedor.bairro() != null && !novosDadosFornecedor.bairro().equals(fornecedor.getBairro())) {
			fornecedor.setBairro(novosDadosFornecedor.bairro());
		}
		if (novosDadosFornecedor.cidade() != null && !novosDadosFornecedor.cidade().equals(fornecedor.getCidade())) {
			fornecedor.setCidade(novosDadosFornecedor.cidade());
		}

		if (novosDadosFornecedor.estado() != null && !novosDadosFornecedor.estado().equals(fornecedor.getEstado())) {
			fornecedor.setEstado(novosDadosFornecedor.estado());
		}

		if (novosDadosFornecedor.telefone() != null && !novosDadosFornecedor.telefone().equals(fornecedor.getTelefone())) {
			fornecedor.setTelefone(novosDadosFornecedor.telefone());
		}
		if (novosDadosFornecedor.email() != null && !novosDadosFornecedor.email().equals(fornecedor.getEmail())) {
			fornecedor.setEmail(novosDadosFornecedor.email());
		}
		
		if (novosDadosFornecedor.site() != null && !novosDadosFornecedor.site().equals(fornecedor.getSite())) {
			fornecedor.setSite(novosDadosFornecedor.site());
		}
		if (novosDadosFornecedor.produto() != null && !novosDadosFornecedor.produto().equals(fornecedor.getProduto())) {
			fornecedor.setProduto(novosDadosFornecedor.produto());
		}
	}
	public void deletar(@Valid String id) {
		Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(() -> new NotFoundException("Fornecedor não encontrado"));
		fornecedor.setAtivo(false);
		fornecedorRepository.save(fornecedor);

	}

}
