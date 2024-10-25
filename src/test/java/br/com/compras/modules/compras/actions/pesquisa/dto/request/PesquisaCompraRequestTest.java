package br.com.compras.modules.compras.actions.pesquisa.dto.request;

import br.com.compras.modules.compras.actions.pesquisa.dto.request.mock.PesquisaCompraRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Request: PesquisaCompra")
class PesquisaCompraRequestTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        PesquisaCompraRequest pesquisaCompraRequest = PesquisaCompraRequestMock.builder().build();

        Assertions.assertEquals(
                "PesquisaCompraRequest(cpfCliente=472.535.279-22, nomeProduto=Sanduicheira, rangeDataPesquisa=null)",
                pesquisaCompraRequest.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        PesquisaCompraRequest pesquisaCompraRequest = new PesquisaCompraRequest(
                "777.777.777-77",
                "Televisão",
                null
        );

        Assertions.assertEquals(
                "PesquisaCompraRequest(cpfCliente=777.777.777-77, nomeProduto=Televisão, rangeDataPesquisa=null)",
                pesquisaCompraRequest.toString()
        );
    }
}
