package br.com.compras.modules.produto.actions.cadastro.dto.response;

import br.com.compras.modules.produto.actions.cadastro.dto.response.mock.CriaProdutoResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@DisplayName("Response: CriaProduto")
class CriaProdutoResponseTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        CriaProdutoResponse criaProdutoResponse = CriaProdutoResponseMock.builder().build();

        Assertions.assertEquals(
                "CriaProdutoResponse(id=74bcd515-655c-4def-8dc8-3329ccbdf62e)",
                criaProdutoResponse.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        CriaProdutoResponse criaProdutoResponse = new  CriaProdutoResponse(
                UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e")
        );

        Assertions.assertEquals(
                "CriaProdutoResponse(id=74bcd515-655c-4def-8dc8-3329ccbdf62e)",
                criaProdutoResponse.toString()
        );
    }

    @Test
    @DisplayName("Deve testar Builder")
    void deveTestarBuilder() {

        CriaProdutoResponse criaProdutoResponseMock =  CriaProdutoResponseMock.builder().build();

        CriaProdutoResponse criaProdutoResponse =  CriaProdutoResponse.builder()
                .id(criaProdutoResponseMock.getId())
                .build();

        Assertions.assertEquals(
                "CriaProdutoResponse(id=74bcd515-655c-4def-8dc8-3329ccbdf62e)",
                criaProdutoResponse.toString()
        );
    }
}
