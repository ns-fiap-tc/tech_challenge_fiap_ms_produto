package br.com.fiap.lanchonete.produto.core.usecase.impl;

import br.com.fiap.lanchonete.produto.adapter.gateway.ProdutoGateway;
import br.com.fiap.lanchonete.produto.core.domain.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoUseCasesImplTest {

    @Mock
    private ProdutoGateway gateway;

    private ProdutoUseCasesImpl useCase;

    @BeforeEach
    void setUp() {
        useCase = new ProdutoUseCasesImpl(gateway);
    }

    @Test
    void shouldSaveProduto() {
        Produto produto = createProduto();
        when(gateway.save(produto)).thenReturn(produto);

        Produto result = useCase.save(produto);

        assertEquals(produto, result);
        verify(gateway).save(produto);
    }

    @Test
    void shouldFindById() {
        Long id = 1L;
        Produto produto = createProduto();
        when(gateway.findById(id)).thenReturn(produto);

        Produto result = useCase.findById(id);

        assertEquals(produto, result);
        verify(gateway).findById(id);
    }

    @Test
    void shouldFindByNome() {
        String nome = "Hambúrguer";
        List<Produto> produtos = Arrays.asList(createProduto());
        when(gateway.findByNome(nome)).thenReturn(produtos);

        List<Produto> result = useCase.findByNome(nome);

        assertEquals(produtos, result);
        verify(gateway).findByNome(nome);
    }

    @Test
    void shouldFindAll() {
        List<Produto> produtos = Arrays.asList(createProduto());
        when(gateway.findAll()).thenReturn(produtos);

        List<Produto> result = useCase.findAll();

        assertEquals(produtos, result);
        verify(gateway).findAll();
    }

    @Test
    void shouldFindByCategoria() {
        Long categoriaId = 1L;
        List<Produto> produtos = Arrays.asList(createProduto());
        when(gateway.findByCategoriaId(categoriaId)).thenReturn(produtos);

        List<Produto> result = useCase.findByCategoria(categoriaId);

        assertEquals(produtos, result);
        verify(gateway).findByCategoriaId(categoriaId);
    }

    @Test
    void shouldDeleteById() {
        Long id = 1L;

        useCase.deleteById(id);

        verify(gateway).deleteById(id);
    }

    private Produto createProduto() {
        return new Produto(1L, 100L, "Hambúrguer", 1L, 300, "http://foto.jpg", 25.90, "Delicioso hambúrguer", new Date(), new Date());
    }
}