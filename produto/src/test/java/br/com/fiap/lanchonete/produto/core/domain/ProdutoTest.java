package br.com.fiap.lanchonete.produto.core.domain;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void shouldCreateProdutoWithAllFields() {
        Date now = new Date();
        Produto produto = new Produto(1L, 100L, "Hambúrguer", 1L, 300, "http://foto.jpg", 25.90, "Delicioso hambúrguer", now, now);
        
        assertEquals(1L, produto.getId());
        assertEquals(100L, produto.getIdRef());
        assertEquals("Hambúrguer", produto.getNome());
        assertEquals(1L, produto.getCategoriaId());
        assertEquals(300, produto.getTempoPreparo());
        assertEquals("http://foto.jpg", produto.getFotoUrl());
        assertEquals(25.90, produto.getPreco());
        assertEquals("Delicioso hambúrguer", produto.getDescricao());
        assertEquals(now, produto.getCreatedAt());
        assertEquals(now, produto.getUpdatedAt());
    }

    @Test
    void shouldCreateEmptyProduto() {
        Produto produto = new Produto();
        
        assertNull(produto.getId());
        assertNull(produto.getNome());
        assertNull(produto.getCategoriaId());
        assertEquals(0, produto.getTempoPreparo());
        assertNull(produto.getFotoUrl());
        assertNull(produto.getPreco());
        assertNull(produto.getDescricao());
    }

    @Test
    void shouldSetAndGetFields() {
        Produto produto = new Produto();
        Date now = new Date();
        
        produto.setId(1L);
        produto.setNome("Pizza");
        produto.setCategoriaId(2L);
        produto.setTempoPreparo(600);
        produto.setFotoUrl("http://pizza.jpg");
        produto.setPreco(35.50);
        produto.setDescricao("Pizza margherita");
        produto.setCreatedAt(now);
        produto.setUpdatedAt(now);
        
        assertEquals(1L, produto.getId());
        assertEquals("Pizza", produto.getNome());
        assertEquals(2L, produto.getCategoriaId());
        assertEquals(600, produto.getTempoPreparo());
        assertEquals("http://pizza.jpg", produto.getFotoUrl());
        assertEquals(35.50, produto.getPreco());
        assertEquals("Pizza margherita", produto.getDescricao());
        assertEquals(now, produto.getCreatedAt());
        assertEquals(now, produto.getUpdatedAt());
    }
}