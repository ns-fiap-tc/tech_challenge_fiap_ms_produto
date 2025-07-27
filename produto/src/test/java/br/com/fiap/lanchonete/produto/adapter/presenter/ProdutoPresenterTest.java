package br.com.fiap.lanchonete.produto.adapter.presenter;

import br.com.fiap.lanchonete.produto.commons.dto.ProdutoDto;
import br.com.fiap.lanchonete.produto.core.domain.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoPresenterTest {

    private ProdutoPresenter presenter;

    @BeforeEach
    void setUp() {
        presenter = new ProdutoPresenter();
    }

    @Test
    void shouldConvertProdutoToDto() {
        Produto produto = createProduto();

        ProdutoDto result = presenter.toDto(produto);

        assertNotNull(result);
        assertEquals(produto.getId(), result.getId());
        assertEquals(produto.getNome(), result.getNome());
        assertEquals(produto.getCategoriaId(), result.getCategoriaId());
        assertEquals(produto.getTempoPreparo(), result.getTempoPreparo());
        assertEquals(produto.getFotoUrl(), result.getFotoUrl());
        assertEquals(produto.getPreco(), result.getPreco());
        assertEquals(produto.getDescricao(), result.getDescricao());
    }

    @Test
    void shouldConvertDtoToProduto() {
        ProdutoDto dto = createProdutoDto();

        Produto result = presenter.toDomain(dto);

        assertNotNull(result);
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getNome(), result.getNome());
        assertEquals(dto.getCategoriaId(), result.getCategoriaId());
        assertEquals(dto.getTempoPreparo(), result.getTempoPreparo());
        assertEquals(dto.getFotoUrl(), result.getFotoUrl());
        assertEquals(dto.getPreco(), result.getPreco());
        assertEquals(dto.getDescricao(), result.getDescricao());
    }

    @Test
    void shouldMapProdutoListToDtoList() {
        List<Produto> produtos = Arrays.asList(createProduto(), createProduto());

        List<ProdutoDto> result = presenter.map(produtos);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(produtos.get(0).getNome(), result.get(0).getNome());
        assertEquals(produtos.get(1).getNome(), result.get(1).getNome());
    }

    @Test
    void shouldHandleNullProduto() {
        ProdutoDto result = presenter.toDto(null);
        assertNull(result);
    }

    @Test
    void shouldHandleNullDto() {
        Produto result = presenter.toDomain(null);
        assertNull(result);
    }

    @Test
    void shouldHandleEmptyList() {
        List<ProdutoDto> result = presenter.map(Arrays.asList());
        
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    private Produto createProduto() {
        return new Produto(1L, 100L, "Hambúrguer", 1L, 300, "http://foto.jpg", 25.90, "Delicioso hambúrguer", new Date(), new Date());
    }

    private ProdutoDto createProdutoDto() {
        ProdutoDto dto = new ProdutoDto();
        dto.setId(1L);
        dto.setNome("Hambúrguer");
        dto.setCategoriaId(1L);
        dto.setTempoPreparo(300);
        dto.setFotoUrl("http://foto.jpg");
        dto.setPreco(25.90);
        dto.setDescricao("Delicioso hambúrguer");
        dto.setCreatedAt(new Date());
        dto.setUpdatedAt(new Date());
        return dto;
    }
}