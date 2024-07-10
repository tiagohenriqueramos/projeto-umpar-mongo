package com.umpar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import com.umpar.domain.Produto;
import com.umpar.dto.ProdutoRegisterDTO;
import com.umpar.exception.CodigoIndisponivelException;
import com.umpar.repository.ProdutoRepository;

@SpringBootTest
@ActiveProfiles("test")
@ComponentScan(basePackages = "com.umpar")
class ProdutoServiceTest {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @BeforeEach
    void setUp() {
        produtoRepository.deleteAll(); 
    }

    @Test
    void testCadastrar() {
        ProdutoRegisterDTO novoProduto = new ProdutoRegisterDTO(
            "00123",
            "Sapato",
            "Couro",
            "Nova Marca",
            "Preta",
            "42",
            "100.00",
            LocalDate.of(2023, 7, 10),
            true
        );

        produtoService.cadastrar(novoProduto);

        Optional<Produto> produto = produtoRepository.findByCodigo("00123");
        assertTrue(produto.isPresent());
        assertEquals("Sapato", produto.get().getNome());
        assertEquals("Couro", produto.get().getMaterial());
        assertEquals("Nova Marca", produto.get().getMarca());
        assertEquals("Preta", produto.get().getCor());
        assertEquals("42", produto.get().getTamanho());
        assertEquals("100.00", produto.get().getPreco());
        assertEquals(LocalDate.of(2023, 7, 10), produto.get().getData());
        assertTrue(produto.get().getAtivo());
    }
    @Test
    void testCadastrarProdutoDuplicado() {
        ProdutoRegisterDTO novoProduto = new ProdutoRegisterDTO(
            "00123",
            "Nome do Produto",
            "Material",
            "Marca",
            "Cor",
            "Tamanho",
            "100.00",
            LocalDate.of(2023, 7, 10),
            true
        );
        produtoService.cadastrar(novoProduto);

        ProdutoRegisterDTO produtoDuplicado = new ProdutoRegisterDTO(
            "00123",
            "Outro Nome",
            "Outro Material",
            "Outra Marca",
            "Outra Cor",
            "Outro Tamanho",
            "200.00",
            LocalDate.of(2023, 8, 15),
            false
        );

        assertThrows(CodigoIndisponivelException.class, () -> {
            produtoService.cadastrar(produtoDuplicado);
        });

        assertEquals(1, produtoRepository.count());
    }
    

    @Test
    void testCadastrarProdutoInativo() {
        ProdutoRegisterDTO novoProduto = new ProdutoRegisterDTO(
            "00124",
            "Nome do Produto Inativo",
            "Material",
            "Marca",
            "Cor",
            "Tamanho",
            "200.00",
            LocalDate.of(2023, 8, 20),
            false 
        );

        produtoService.cadastrar(novoProduto);

        Optional<Produto> produtoOptional = produtoRepository.findByCodigo("00124");
        assertTrue(produtoOptional.isPresent(), "Produto não foi encontrado no repositório");

        Produto produto = produtoOptional.get();

        assertEquals("Nome do Produto Inativo", produto.getNome());
        assertEquals("Material", produto.getMaterial());
        assertEquals("Marca", produto.getMarca());
        assertEquals("Cor", produto.getCor());
        assertEquals("Tamanho", produto.getTamanho());
        assertEquals("200.00", produto.getPreco());
        assertEquals(LocalDate.of(2023, 8, 20), produto.getData());
        assertFalse(produto.getAtivo(), "Produto não deveria estar ativo");
    }
}
	

