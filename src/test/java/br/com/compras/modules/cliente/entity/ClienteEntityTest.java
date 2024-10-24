package br.com.compras.modules.cliente.entity;

import br.com.compras.modules.cliente.entity.mock.ClienteEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@DisplayName("Entity: Cliente")
class ClienteEntityTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        ClienteEntity cliente = ClienteEntityMock.builder().build();

        Assertions.assertEquals(
                "ClienteEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Gabriel Lagrota, cpf=123.189.265-38)",
                cliente.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        ClienteEntity cliente = new ClienteEntity(
                UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"),
                "Gabriel Lagrota",
                "111.111.111-11"
        );

        Assertions.assertEquals(
                "ClienteEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Gabriel Lagrota, cpf=111.111.111-11)",
                cliente.toString()
        );
    }

    @Test
    @DisplayName("Deve testar Builder")
    void deveTestarBuilder() {

        ClienteEntity clienteEntityMock = ClienteEntityMock.builder().build();

        ClienteEntity cliente = ClienteEntity.builder()
                .id(clienteEntityMock.getId())
                .nome(clienteEntityMock.getNome())
                .build();

        Assertions.assertEquals(
                "ClienteEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Gabriel Lagrota, cpf=null)",
                cliente.toString()
        );
    }
}
