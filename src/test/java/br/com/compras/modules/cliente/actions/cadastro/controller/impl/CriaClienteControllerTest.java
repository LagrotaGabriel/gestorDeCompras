package br.com.compras.modules.cliente.actions.cadastro.controller.impl;

import br.com.compras.modules.cliente.actions.cadastro.dto.request.CriaClienteRequest;
import br.com.compras.modules.cliente.actions.cadastro.dto.request.mock.CriaClienteRequestMock;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.CriaClienteResponse;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.mock.CriaClienteResponseMock;
import br.com.compras.modules.cliente.actions.cadastro.service.core.CriaClienteService;
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
@DisplayName("Controller: CriaCliente")
class CriaClienteControllerTest {

    @InjectMocks
    CriaClienteController criaClienteController;

    @Mock
    CriaClienteService criaClienteService;

    @Test
    @DisplayName("Deve testar endpoint de criacao de novo cliente")
    void deveTestarEndpointDeCriacaoDeNovoCliente() {

        CriaClienteRequest criaClienteRequestMock = CriaClienteRequestMock.builder().build();
        CriaClienteResponse criaClienteResponseMock = CriaClienteResponseMock.builder().build();

        when(criaClienteService.realizaCadastroDoCliente(any())).thenReturn(criaClienteResponseMock);

        ResponseEntity<CriaClienteResponse> criaClienteResponseResponseEntity =
                criaClienteController.criaNovoCliente(
                        criaClienteRequestMock
                );

        Assertions.assertEquals(
                "<201 CREATED Created,CriaClienteResponse(id=74bcd515-655c-4def-8dc8-3329ccbdf62e),[]>",
                criaClienteResponseResponseEntity.toString()
        );
    }
}
