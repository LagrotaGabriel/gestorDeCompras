package br.com.compras.modules.compras.actions.pesquisa.controller;

import br.com.compras.modules.compras.actions.pesquisa.controller.impl.PesquisaCompraController;
import br.com.compras.modules.compras.actions.pesquisa.dto.request.PesquisaCompraRequest;
import br.com.compras.modules.compras.actions.pesquisa.dto.request.mock.PesquisaCompraRequestMock;
import br.com.compras.modules.compras.actions.pesquisa.dto.response.PesquisaCompraResponse;
import br.com.compras.modules.compras.actions.pesquisa.dto.response.mock.PesquisaCompraResponseMock;
import br.com.compras.modules.compras.actions.pesquisa.service.core.PesquisaCompraService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Controller: PesquisaCompra")
class PesquisaCompraControllerImplTest {

    @InjectMocks
    PesquisaCompraController pesquisaCompraController;

    @Mock
    PesquisaCompraService pesquisaCompraService;

    @Test
    @DisplayName("Deve testar endpoint de pesquisa de compras")
    void deveTestarEndpointDePesquisaDeCompras() {

        PesquisaCompraRequest pesquisaCompraRequest = PesquisaCompraRequestMock.builder().build();
        List<PesquisaCompraResponse> pesquisaCompraResponseLIST = PesquisaCompraResponseMock.builder().buildList();

        when(pesquisaCompraService.pesquisaCompras(any())).thenReturn(pesquisaCompraResponseLIST);

        ResponseEntity<List<PesquisaCompraResponse>> pesquisaCompraResponseEntity =
                pesquisaCompraController.pesquisaCompras(
                        pesquisaCompraRequest
                );

        Assertions.assertEquals(
                "<200 OK OK,[PesquisaCompraResponse(id=98355f25-bcb7-43f3-a2f0-8ce15bf910ca, " +
                        "dataHoraCadastro=2024-10-25T00:38, quantidade=1, valorUnitario=10.0, valorTotal=10.0, " +
                        "nomeProduto=Impressora, nomeCliente=Adailton, cpfCliente=888.888.888-88)],[]>",
                pesquisaCompraResponseEntity.toString()
        );
    }
}
