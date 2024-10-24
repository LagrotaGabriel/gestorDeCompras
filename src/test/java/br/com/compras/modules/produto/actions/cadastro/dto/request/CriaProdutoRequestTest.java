package br.com.compras.modules.produto.actions.cadastro.dto.request;

import br.com.compras.modules.produto.actions.cadastro.dto.request.mock.CriaProdutoRequestMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Request: CriaProduto")
class CriaProdutoRequestTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        CriaProdutoRequest criaProdutoRequest = CriaProdutoRequestMock.builder().build();

        Assertions.assertEquals(
                "CriaProdutoRequest(nome=Liquidificador)",
                criaProdutoRequest.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        CriaProdutoRequest criaProdutoRequest = new  CriaProdutoRequest(
                "Mouse sem fio"
        );

        Assertions.assertEquals(
                "CriaProdutoRequest(nome=Mouse sem fio)",
                criaProdutoRequest.toString()
        );
    }
}
