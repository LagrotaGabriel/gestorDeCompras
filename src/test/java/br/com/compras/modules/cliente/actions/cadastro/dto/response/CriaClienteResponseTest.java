package br.com.compras.modules.cliente.actions.cadastro.dto.response;

import br.com.compras.modules.cliente.actions.cadastro.dto.response.mock.CriaClienteResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@DisplayName("Response: CriaCliente")
class CriaClienteResponseTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        CriaClienteResponse criaClienteResponse = CriaClienteResponseMock.builder().build();

        Assertions.assertEquals(
                "CriaClienteResponse(id=74bcd515-655c-4def-8dc8-3329ccbdf62e)",
                criaClienteResponse.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        CriaClienteResponse criaClienteResponse = new CriaClienteResponse(
                UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e")
        );

        Assertions.assertEquals(
                "CriaClienteResponse(id=74bcd515-655c-4def-8dc8-3329ccbdf62e)",
                criaClienteResponse.toString()
        );
    }

    @Test
    @DisplayName("Deve testar Builder")
    void deveTestarBuilder() {

        CriaClienteResponse criaClienteResponseMock = CriaClienteResponseMock.builder().build();

        CriaClienteResponse criaClienteResponse = CriaClienteResponse.builder()
                .id(criaClienteResponseMock.getId())
                .build();

        Assertions.assertEquals(
                "CriaClienteResponse(id=74bcd515-655c-4def-8dc8-3329ccbdf62e)",
                criaClienteResponse.toString()
        );
    }
}
