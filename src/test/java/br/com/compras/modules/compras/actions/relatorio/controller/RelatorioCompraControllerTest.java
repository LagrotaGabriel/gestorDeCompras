package br.com.compras.modules.compras.actions.relatorio.controller;

import br.com.compras.modules.compras.actions.relatorio.controller.impl.RelatorioCompraController;
import br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse;
import br.com.compras.modules.compras.actions.relatorio.dto.mock.RelatorioCompraResponseMock;
import br.com.compras.modules.compras.actions.relatorio.service.RelatorioCompraService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Controller: RelatorioCompra")
class RelatorioCompraControllerTest {

    @InjectMocks
    RelatorioCompraController relatorioCompraController;

    @Mock
    RelatorioCompraService relatorioCompraService;

    @Test
    @DisplayName("Deve testar endpoint de pesquisa de compras")
    void deveTestarEndpointDePesquisaDeCompras() {

        RelatorioCompraResponse relatorioCompraResponse = RelatorioCompraResponseMock.builder().build();

        when(relatorioCompraService.geraRelatorioDeComprasPorPeriodo(any(), any())).thenReturn(relatorioCompraResponse);

        ResponseEntity<RelatorioCompraResponse> pesquisaCompraResponseEntity =
                relatorioCompraController.relatorioCompras(
                        LocalDate.of(2024, 10, 20),
                        LocalDate.of(2024, 10, 25)
                );

        Assertions.assertEquals(
                "<200 OK OK,RelatorioCompraResponse(quantidadeTotalDeComprasRealizadas=5, " +
                        "quantidadeTotalDeProdutosAdquiridos=5, valorTotalCompras=10000.0, " +
                        "produtosRelatorio=[ProdutoRelatorioCompraResponse(nomeProduto=Impressora, " +
                        "valorTotalVendido=10000.0, quantidadeTotalVendida=5)]),[]>",
                pesquisaCompraResponseEntity.toString()
        );
    }
}
