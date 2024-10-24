package br.com.compras.modules.produto.actions.cadastro.service.core;

import br.com.compras.modules.produto.actions.cadastro.dto.request.CriaProdutoRequest;
import br.com.compras.modules.produto.actions.cadastro.dto.request.mock.CriaProdutoRequestMock;
import br.com.compras.modules.produto.actions.cadastro.dto.response.CriaProdutoResponse;
import br.com.compras.modules.produto.actions.cadastro.dto.response.mock.CriaProdutoResponseMock;
import br.com.compras.modules.produto.actions.cadastro.service.core.impl.CriaProdutoServiceImpl;
import br.com.compras.modules.produto.actions.cadastro.service.mapper.CriaProdutoMapperService;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.entity.mock.ProdutoEntityMock;
import br.com.compras.modules.produto.repository.dao.ProdutoDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Service: CriaProduto")
class CriaProdutoServiceImplTest {

    @InjectMocks
    CriaProdutoServiceImpl criaProdutoService;

    @Mock
    CriaProdutoMapperService mapperService;

    @Mock
    ProdutoDAO produtoDAO;

    @Test
    @DisplayName("Deve testar criacao de novo produto")
    void deveTestarCriacaoDeNovoProduto() {

        CriaProdutoRequest criaProdutoRequestMock = CriaProdutoRequestMock.builder().build();
        ProdutoEntity produtoEntityMock = ProdutoEntityMock.builder().build();
        CriaProdutoResponse criaProdutoResponseMock = CriaProdutoResponseMock.builder().build();

        when(mapperService.realizaCriacaoDeProdutoEntityAPartirDeCriaProdutoRequest(any())).thenReturn(produtoEntityMock);
        when(produtoDAO.persisteEntidade(any())).thenReturn(produtoEntityMock);
        when(mapperService.realizaCriacaoDeCriaProdutoResponseAPartirDeProdutoEntity(any())).thenReturn(criaProdutoResponseMock);

        CriaProdutoResponse criaProdutoResponseRetornado =
                criaProdutoService.realizaCriacaoDeUmNovoProduto(
                        criaProdutoRequestMock
                );

        Assertions.assertEquals(
                criaProdutoResponseMock,
                criaProdutoResponseRetornado
        );
    }
}
