package br.com.compras.modules.produto.actions.cadastro.controller;

import br.com.compras.modules.produto.actions.cadastro.controller.impl.CriaProdutoController;
import br.com.compras.modules.produto.actions.cadastro.dto.request.CriaProdutoRequest;
import br.com.compras.modules.produto.actions.cadastro.dto.request.mock.CriaProdutoRequestMock;
import br.com.compras.modules.produto.actions.cadastro.dto.response.CriaProdutoResponse;
import br.com.compras.modules.produto.actions.cadastro.dto.response.mock.CriaProdutoResponseMock;
import br.com.compras.modules.produto.actions.cadastro.service.core.CriaProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Controller: CriaProduto")
class CriaProdutoControllerTest {

    @InjectMocks
    CriaProdutoController criaProdutoController;

    @Mock
    CriaProdutoService criaProdutoService;

    @Test
    @DisplayName("Deve testar endpoint de criacao de novo produto")
    void deveTestarEndpointDeCriacaoDeNovoProduto() {

        CriaProdutoRequest criaProdutoRequestMock = CriaProdutoRequestMock.builder().build();
        CriaProdutoResponse criaProdutoResponseMock = CriaProdutoResponseMock.builder().build();

        when(criaProdutoService.realizaCriacaoDeUmNovoProduto(any())).thenReturn(criaProdutoResponseMock);

        ResponseEntity<CriaProdutoResponse> criaProdutoResponseResponseEntity =
                criaProdutoController.criaNovoProduto(
                        criaProdutoRequestMock
                );

        Assertions.assertEquals(
                "<201 CREATED Created,CriaProdutoResponse(id=74bcd515-655c-4def-8dc8-3329ccbdf62e),[]>",
                criaProdutoResponseResponseEntity.toString()
        );
    }
}
