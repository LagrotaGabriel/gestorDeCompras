package br.com.compras.modules.compras.actions.relatorio.dto;

import br.com.compras.modules.compras.actions.relatorio.dto.mock.ProdutoRelatorioCompraResponseMock;
import br.com.compras.modules.compras.actions.relatorio.dto.mock.RelatorioCompraResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@DisplayName("Response: RelatorioCompra")
class RelatorioCompraResponseTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        RelatorioCompraResponse relatorioCompraResponse = RelatorioCompraResponseMock.builder().build();

        Assertions.assertEquals(
                "RelatorioCompraResponse(quantidadeTotalDeComprasRealizadas=5, " +
                        "quantidadeTotalDeProdutosAdquiridos=5, valorTotalCompras=10000.0, " +
                        "produtosRelatorio=[ProdutoRelatorioCompraResponse(nomeProduto=Impressora, " +
                        "valorTotalVendido=10000.0, quantidadeTotalVendida=5)])",
                relatorioCompraResponse.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        RelatorioCompraResponse relatorioCompraResponse = new RelatorioCompraResponse(
                5L,
                5L,
                BigDecimal.valueOf(10000.0),
                ProdutoRelatorioCompraResponseMock.builder().buildList()
        );

        Assertions.assertEquals(
                "RelatorioCompraResponse(quantidadeTotalDeComprasRealizadas=5, " +
                        "quantidadeTotalDeProdutosAdquiridos=5, valorTotalCompras=10000.0, " +
                        "produtosRelatorio=[ProdutoRelatorioCompraResponse(nomeProduto=Impressora, " +
                        "valorTotalVendido=10000.0, quantidadeTotalVendida=5)])",
                relatorioCompraResponse.toString()
        );
    }
}
