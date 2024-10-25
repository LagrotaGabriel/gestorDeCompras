package br.com.compras.modules.compras.actions.cadastro.controller;

import br.com.compras.modules.compras.actions.cadastro.controller.impl.CriaCompraController;
import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.dto.request.mock.CriaCompraRequestMock;
import br.com.compras.modules.compras.actions.cadastro.dto.response.CriaCompraResponse;
import br.com.compras.modules.compras.actions.cadastro.dto.response.mock.CriaCompraResponseMock;
import br.com.compras.modules.compras.actions.cadastro.services.core.CriaCompraService;
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
@DisplayName("Controller: CriaCompra")
class CriaCompraControllerTest {

    @InjectMocks
    CriaCompraController criaCompraController;

    @Mock
    CriaCompraService criaCompraService;

    @Test
    @DisplayName("Deve testar endpoint de criacao de nova compra")
    void deveTestarEndpointDeCriacaoDeNovaCompra() {

        CriaCompraRequest criaCompraRequestMock = CriaCompraRequestMock.builder().build();
        CriaCompraResponse criaCompraResponseMock = CriaCompraResponseMock.builder().build();

        when(criaCompraService.realizaCadastroDeCompra(any())).thenReturn(criaCompraResponseMock);

        ResponseEntity<CriaCompraResponse> criaCompraResponseResponseEntity =
                criaCompraController.criaNovaCompra(
                        criaCompraRequestMock
                );

        Assertions.assertEquals(
                "<201 CREATED Created,CriaCompraResponse(id=cf004916-9faa-4b6f-9178-dd781644cdee),[]>",
                criaCompraResponseResponseEntity.toString()
        );
    }
}
