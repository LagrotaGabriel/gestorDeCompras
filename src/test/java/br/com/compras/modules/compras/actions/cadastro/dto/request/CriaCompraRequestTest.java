package br.com.compras.modules.compras.actions.cadastro.dto.request;

import br.com.compras.modules.compras.actions.cadastro.dto.request.mock.CriaCompraRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@DisplayName("Request: CriaCompra")
class CriaCompraRequestTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        CriaCompraRequest compra = CriaCompraRequestMock.builder().build();

        Assertions.assertEquals(
                "CriaCompraRequest(quantidade=1, valorUnitario=100.0, nomeProduto=Sanduicheira, cpfComprador=472.535.279-22)",
                compra.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        CriaCompraRequest compra = new CriaCompraRequest(
                1,
                BigDecimal.valueOf(100.0),
                "Relógio",
                "111.111.111-11"
        );

        Assertions.assertEquals(
                "CriaCompraRequest(quantidade=1, valorUnitario=100.0, nomeProduto=Relógio, cpfComprador=111.111.111-11)",
                compra.toString()
        );
    }
}
