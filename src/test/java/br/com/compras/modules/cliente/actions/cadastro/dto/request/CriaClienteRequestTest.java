package br.com.compras.modules.cliente.actions.cadastro.dto.request;

import br.com.compras.modules.cliente.actions.cadastro.dto.request.mock.CriaClienteRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Request: CriaCliente")
class CriaClienteRequestTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        CriaClienteRequest criaClienteRequest = CriaClienteRequestMock.builder().build();

        Assertions.assertEquals(
                "CriaClienteRequest(cpf=222.222.222-22, nome=Gabriel Lagrota)",
                criaClienteRequest.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        CriaClienteRequest criaClienteRequest = new CriaClienteRequest(
                "Fulano de Souza",
                "333.333.333-33"
        );

        Assertions.assertEquals(
                "CriaClienteRequest(cpf=Fulano de Souza, nome=333.333.333-33)",
                criaClienteRequest.toString()
        );
    }
}
