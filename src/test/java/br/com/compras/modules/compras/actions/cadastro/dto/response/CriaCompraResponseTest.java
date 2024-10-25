package br.com.compras.modules.compras.actions.cadastro.dto.response;

import br.com.compras.modules.compras.actions.cadastro.dto.response.mock.CriaCompraResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@DisplayName("Response: CriaCompra")
class CriaCompraResponseTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        CriaCompraResponse compra = CriaCompraResponseMock.builder().build();

        Assertions.assertEquals(
                "CriaCompraResponse(id=cf004916-9faa-4b6f-9178-dd781644cdee)",
                compra.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        CriaCompraResponse compra = new CriaCompraResponse(
                UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e")
        );

        Assertions.assertEquals(
                "CriaCompraResponse(id=74bcd515-655c-4def-8dc8-3329ccbdf62e)",
                compra.toString()
        );
    }

    @Test
    @DisplayName("Deve testar Builder")
    void deveTestarBuilder() {

        CriaCompraResponse criaCompraResponseMock = CriaCompraResponseMock.builder().build();

        CriaCompraResponse compra = CriaCompraResponse.builder()
                .id(criaCompraResponseMock.getId())
                .build();

        Assertions.assertEquals(
                "CriaCompraResponse(id=cf004916-9faa-4b6f-9178-dd781644cdee)",
                compra.toString()
        );
    }
}
