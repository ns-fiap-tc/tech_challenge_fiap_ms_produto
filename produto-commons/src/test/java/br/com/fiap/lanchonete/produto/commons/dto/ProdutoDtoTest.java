package br.com.fiap.lanchonete.produto.commons.dto;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoDtoTest {

    @Test
    void shouldCreateProdutoDtoWithAllFields() {
        Date now = new Date();
        ProdutoDto dto = new ProdutoDto(1L, "Hambúrguer", 1L, 300, "http://foto.jpg", 25.90, "Delicioso hambúrguer", now, now);
        
        assertEquals(1L, dto.getId());
        assertEquals("Hambúrguer", dto.getNome());
        assertEquals(1L, dto.getCategoriaId());
        assertEquals(300, dto.getTempoPreparo());
        assertEquals("http://foto.jpg", dto.getFotoUrl());
        assertEquals(25.90, dto.getPreco());
        assertEquals("Delicioso hambúrguer", dto.getDescricao());
        assertEquals(now, dto.getCreatedAt());
        assertEquals(now, dto.getUpdatedAt());
    }

    @Test
    void shouldCreateEmptyProdutoDto() {
        ProdutoDto dto = new ProdutoDto();
        
        assertNull(dto.getId());
        assertNull(dto.getNome());
        assertNull(dto.getCategoriaId());
        assertEquals(0, dto.getTempoPreparo());
        assertNull(dto.getFotoUrl());
        assertNull(dto.getPreco());
        assertNull(dto.getDescricao());
        assertNull(dto.getCreatedAt());
        assertNull(dto.getUpdatedAt());
    }

    @Test
    void shouldSetAndGetFields() {
        ProdutoDto dto = new ProdutoDto();
        Date now = new Date();
        
        dto.setId(1L);
        dto.setNome("Pizza");
        dto.setCategoriaId(2L);
        dto.setTempoPreparo(600);
        dto.setFotoUrl("http://pizza.jpg");
        dto.setPreco(35.50);
        dto.setDescricao("Pizza margherita");
        dto.setCreatedAt(now);
        dto.setUpdatedAt(now);
        
        assertEquals(1L, dto.getId());
        assertEquals("Pizza", dto.getNome());
        assertEquals(2L, dto.getCategoriaId());
        assertEquals(600, dto.getTempoPreparo());
        assertEquals("http://pizza.jpg", dto.getFotoUrl());
        assertEquals(35.50, dto.getPreco());
        assertEquals("Pizza margherita", dto.getDescricao());
        assertEquals(now, dto.getCreatedAt());
        assertEquals(now, dto.getUpdatedAt());
    }
}