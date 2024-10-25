package br.com.compras.modules.compras.actions.relatorio.dto;

import br.com.compras.modules.compras.actions.relatorio.dto.mock.ProdutoRelatorioCompraResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@DisplayName("Response: ProdutoRelatorioCompra")
class ProdutoRelatorioCompraResponseTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        ProdutoRelatorioCompraResponse produtoRelatorioCompraResponse = ProdutoRelatorioCompraResponseMock.builder().build();

        Assertions.assertEquals(
                "ProdutoRelatorioCompraResponse(nomeProduto=Impressora, valorTotalVendido=10000.0, quantidadeTotalVendida=5)",
                produtoRelatorioCompraResponse.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        ProdutoRelatorioCompraResponse produtoRelatorioCompraResponse = new ProdutoRelatorioCompraResponse(
                "Impressora",
                BigDecimal.valueOf(10000.0),
                5L
        );

        Assertions.assertEquals(
                "ProdutoRelatorioCompraResponse(nomeProduto=Impressora, valorTotalVendido=10000.0, quantidadeTotalVendida=5)",
                produtoRelatorioCompraResponse.toString()
        );
    }
}
