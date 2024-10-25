package br.com.compras.modules.compras.entity;

import br.com.compras.modules.compras.entity.mock.CompraEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
@DisplayName("Entity: Compra")
class CompraEntityTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        CompraEntity compra = CompraEntityMock.builder().build();

        Assertions.assertEquals(
                "CompraEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, dataHoraCadastro=2024-10-24T16:35, quantidade=1, valorUnitario=100.0)",
                compra.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        CompraEntity compra = new CompraEntity(
                UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"),
                LocalDateTime.of(2024, 10, 24, 16, 35, 0),
                1,
                BigDecimal.valueOf(100.0),
                null,
                null
        );

        Assertions.assertEquals(
                "CompraEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, dataHoraCadastro=2024-10-24T16:35, quantidade=1, valorUnitario=100.0)",
                compra.toString()
        );
    }

    @Test
    @DisplayName("Deve testar Builder")
    void deveTestarBuilder() {

        CompraEntity compraEntityMock = CompraEntityMock.builder().build();

        CompraEntity compra = CompraEntity.builder()
                .id(compraEntityMock.getId())
                .dataHoraCadastro(LocalDateTime.of(2024, 10, 24, 16, 35, 0))
                .quantidade(1)
                .valorUnitario(BigDecimal.valueOf(100.0))
                .produto(null)
                .cliente(null)
                .build();

        Assertions.assertEquals(
                "CompraEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, dataHoraCadastro=2024-10-24T16:35, quantidade=1, valorUnitario=100.0)",
                compra.toString()
        );
    }
}
