package br.com.compras.modules.compras.actions.pesquisa.dto.request;

import br.com.compras.modules.compras.actions.pesquisa.dto.request.mock.DataPesquisaCompraRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Request: DataPesquisaCompra")
class DataPesquisaCompraRequestTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        DataPesquisaCompraRequest dataPesquisaCompraRequest = DataPesquisaCompraRequestMock.builder().build();

        Assertions.assertEquals(
                "DataPesquisaCompraRequest(dataInicio=2024-10-25, dataFim=2024-10-25)",
                dataPesquisaCompraRequest.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        DataPesquisaCompraRequest dataPesquisaCompraRequest = new DataPesquisaCompraRequest(
                "2024-10-25",
                "2024-10-26"
        );

        Assertions.assertEquals(
                "DataPesquisaCompraRequest(dataInicio=2024-10-25, dataFim=2024-10-26)",
                dataPesquisaCompraRequest.toString()
        );
    }
}
