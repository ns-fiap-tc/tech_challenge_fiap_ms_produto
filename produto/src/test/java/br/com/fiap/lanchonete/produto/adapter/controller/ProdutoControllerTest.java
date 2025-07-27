package br.com.fiap.lanchonete.produto.adapter.controller;

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
class ProdutoControllerTest {

    @Mock
    private ProdutoRepository repository;

    private ProdutoController controller;

    @BeforeEach
    void setUp() {
        controller = new ProdutoController(repository);
    }

    @Test
    void shouldSaveProduto() {
        ProdutoDto inputDto = createProdutoDto();
        ProdutoDto savedDto = createProdutoDto();
        savedDto.setId(1L);
        
        when(repository.save(any(ProdutoDto.class))).thenReturn(savedDto);

        ProdutoDto result = controller.save(inputDto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(repository).save(any(ProdutoDto.class));
    }

    @Test
    void shouldFindById() {
        Long id = 1L;
        ProdutoDto dto = createProdutoDto();
        dto.setId(id);
        
        when(repository.findById(id)).thenReturn(dto);

        ProdutoDto result = controller.findById(id);

        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getNome(), result.getNome());
        verify(repository).findById(id);
    }

    @Test
    void shouldFindByNome() {
        String nome = "Hambúrguer";
        List<ProdutoDto> dtos = Arrays.asList(createProdutoDto());
        
        when(repository.findByNome(nome)).thenReturn(dtos);

        List<ProdutoDto> result = controller.findByNome(nome);

        assertEquals(1, result.size());
        verify(repository).findByNome(nome);
    }

    @Test
    void shouldFindAll() {
        List<ProdutoDto> dtos = Arrays.asList(createProdutoDto());
        
        when(repository.findAll()).thenReturn(dtos);

        List<ProdutoDto> result = controller.findAll();

        assertEquals(1, result.size());
        verify(repository).findAll();
    }

    @Test
    void shouldFindByCategoria() {
        Long categoriaId = 1L;
        List<ProdutoDto> dtos = Arrays.asList(createProdutoDto());
        
        when(repository.findByCategoriaId(categoriaId)).thenReturn(dtos);

        List<ProdutoDto> result = controller.findByCategoria(categoriaId);

        assertEquals(1, result.size());
        verify(repository).findByCategoriaId(categoriaId);
    }

    @Test
    void shouldDeleteById() {
        Long id = 1L;

        controller.deleteById(id);

        verify(repository).deleteById(id);
    }

    private ProdutoDto createProdutoDto() {
        ProdutoDto dto = new ProdutoDto();
        dto.setNome("Hambúrguer");
        dto.setCategoriaId(1L);
        dto.setTempoPreparo(300);
        dto.setFotoUrl("http://foto.jpg");
        dto.setPreco(25.90);
        dto.setDescricao("Delicioso hambúrguer");
        return dto;
    }
}