package br.com.compras.modules.produto.entity;

import br.com.compras.modules.produto.entity.mock.ProdutoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@DisplayName("Entity: Produto")
class ProdutoEntityTest {

    @Test
    @DisplayName("Deve testar Mock")
    void deveTestarMock() {

        ProdutoEntity produto = ProdutoEntityMock.builder().build();

        Assertions.assertEquals(
                "ProdutoEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Batedeira)",
                produto.toString()
        );
    }

    @Test
    @DisplayName("Deve testar AllArgsConstructor")
    void deveTestarAllArgsConstructor() {

        ProdutoEntity produto = new ProdutoEntity(
                UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"),
                "Fone de ouvido"
        );

        Assertions.assertEquals(
                "ProdutoEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Fone de ouvido)",
                produto.toString()
        );
    }

    @Test
    @DisplayName("Deve testar Builder")
    void deveTestarBuilder() {

        ProdutoEntity produtoEntityMock = ProdutoEntityMock.builder().build();

        ProdutoEntity produto = ProdutoEntity.builder()
                .id(produtoEntityMock.getId())
                .nome(produtoEntityMock.getNome())
                .build();

        Assertions.assertEquals(
                "ProdutoEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Batedeira)",
                produto.toString()
        );
    }
}
