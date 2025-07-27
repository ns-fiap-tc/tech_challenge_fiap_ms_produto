package br.com.fiap.lanchonete.produto.adapter.gateway;

import br.com.fiap.lanchonete.produto.commons.dto.ProdutoDto;
import br.com.fiap.lanchonete.produto.commons.persistence.ProdutoRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoGatewayTest {

    @Mock
    private ProdutoRepository repository;

    private ProdutoGateway gateway;

    @BeforeEach
    void setUp() {
        gateway = new ProdutoGateway(repository);
    }

    @Test
    void shouldSaveProduto() {
        Produto produto = createProduto();
        ProdutoDto dto = createProdutoDto();
        
        when(repository.save(any(ProdutoDto.class))).thenReturn(dto);

        Produto result = gateway.save(produto);

        assertNotNull(result);
        assertEquals(produto.getNome(), result.getNome());
        verify(repository).save(any(ProdutoDto.class));
    }

    @Test
    void shouldFindById() {
        Long id = 1L;
        ProdutoDto dto = createProdutoDto();
        
        when(repository.findById(id)).thenReturn(dto);

        Produto result = gateway.findById(id);

        assertNotNull(result);
        assertEquals(dto.getNome(), result.getNome());
        verify(repository).findById(id);
    }

    @Test
    void shouldFindByNome() {
        String nome = "Hambúrguer";
        List<ProdutoDto> dtos = Arrays.asList(createProdutoDto());
        
        when(repository.findByNome(nome)).thenReturn(dtos);

        List<Produto> result = gateway.findByNome(nome);

        assertEquals(1, result.size());
        verify(repository).findByNome(nome);
    }

    @Test
    void shouldFindAll() {
        List<ProdutoDto> dtos = Arrays.asList(createProdutoDto());
        
        when(repository.findAll()).thenReturn(dtos);

        List<Produto> result = gateway.findAll();

        assertEquals(1, result.size());
        verify(repository).findAll();
    }

    @Test
    void shouldFindByCategoriaId() {
        Long categoriaId = 1L;
        List<ProdutoDto> dtos = Arrays.asList(createProdutoDto());
        
        when(repository.findByCategoriaId(categoriaId)).thenReturn(dtos);

        List<Produto> result = gateway.findByCategoriaId(categoriaId);

        assertEquals(1, result.size());
        verify(repository).findByCategoriaId(categoriaId);
    }

    @Test
    void shouldDeleteById() {
        Long id = 1L;

        gateway.deleteById(id);

        verify(repository).deleteById(id);
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