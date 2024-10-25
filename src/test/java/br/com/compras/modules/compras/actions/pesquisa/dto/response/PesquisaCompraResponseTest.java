package br.com.compras.modules.compras.actions.pesquisa.dto.response;

import br.com.compras.modules.compras.actions.pesquisa.dto.response.mock.PesquisaCompraResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
@DisplayName("Response: PesquisaCompra")
class PesquisaCompraResponseTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        PesquisaCompraResponse pesquisaCompraResponse = PesquisaCompraResponseMock.builder().build();

        Assertions.assertEquals(
                "PesquisaCompraResponse(id=98355f25-bcb7-43f3-a2f0-8ce15bf910ca, " +
                        "dataHoraCadastro=2024-10-25T00:38, quantidade=1, valorUnitario=10.0, valorTotal=10.0, " +
                        "nomeProduto=Impressora, nomeCliente=Adailton, cpfCliente=888.888.888-88)",
                pesquisaCompraResponse.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        PesquisaCompraResponse pesquisaCompraResponse = new PesquisaCompraResponse(
                UUID.fromString("98355f25-bcb7-43f3-a2f0-8ce15bf910ca"),
                LocalDateTime.of(2024, 10, 25, 0, 38, 0),
                1,
                BigDecimal.valueOf(10.0),
                BigDecimal.valueOf(10.0),
                "Impressora",
                "Adailton",
                "888.888.888-88"
        );

        Assertions.assertEquals(
                "PesquisaCompraResponse(id=98355f25-bcb7-43f3-a2f0-8ce15bf910ca, " +
                        "dataHoraCadastro=2024-10-25T00:38, quantidade=1, valorUnitario=10.0, valorTotal=10.0, " +
                        "nomeProduto=Impressora, nomeCliente=Adailton, cpfCliente=888.888.888-88)",
                pesquisaCompraResponse.toString()
        );
    }

    @Test
    @DisplayName("Deve testar Builder")
    void deveTestarBuilder() {

        PesquisaCompraResponse pesquisaCompraResponse = PesquisaCompraResponse.builder()
                .id(UUID.fromString("98355f25-bcb7-43f3-a2f0-8ce15bf910ca"))
                .dataHoraCadastro(LocalDateTime.of(2024, 10, 25, 0, 38, 0))
                .quantidade(1)
                .valorUnitario(BigDecimal.valueOf(10.0))
                .valorTotal(BigDecimal.valueOf(10.0))
                .nomeProduto("Impressora")
                .nomeCliente("Adailton")
                .cpfCliente("888.888.888-88")
                .build();

        Assertions.assertEquals(
                "PesquisaCompraResponse(id=98355f25-bcb7-43f3-a2f0-8ce15bf910ca, " +
                        "dataHoraCadastro=2024-10-25T00:38, quantidade=1, valorUnitario=10.0, valorTotal=10.0, " +
                        "nomeProduto=Impressora, nomeCliente=Adailton, cpfCliente=888.888.888-88)",
                pesquisaCompraResponse.toString()
        );
    }
}
