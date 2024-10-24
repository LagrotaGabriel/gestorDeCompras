package br.com.compras.modules.produto.actions.cadastro.service.mapper;

import br.com.compras.modules.produto.actions.cadastro.dto.request.CriaProdutoRequest;
import br.com.compras.modules.produto.actions.cadastro.dto.request.mock.CriaProdutoRequestMock;
import br.com.compras.modules.produto.actions.cadastro.dto.response.CriaProdutoResponse;
import br.com.compras.modules.produto.actions.cadastro.service.mapper.impl.CriaProdutoMapperServiceImpl;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.entity.mock.ProdutoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Mapper: CriaProduto")
class CriaProdutoMapperServiceImplTest {

    @InjectMocks
    CriaProdutoMapperServiceImpl mapperServiceImpl;

    @Test
    @DisplayName("Deve testar conversao de ProdutoEntity a partir de CriaProdutoRequest")
    void deveTestarConversaoDeProdutoEntityAPartirDeCriaProdutoRequest() {

        CriaProdutoRequest criaProdutoRequestMock = CriaProdutoRequestMock.builder().build();

        ProdutoEntity produtoEntityGerado =
                mapperServiceImpl.realizaCriacaoDeProdutoEntityAPartirDeCriaProdutoRequest(
                        criaProdutoRequestMock
                );

        Assertions.assertNotNull(
                produtoEntityGerado.toString()
        );
    }

    @Test
    @DisplayName("Deve testar conversao de CriaProdutoResponse a partir de ProdutoEntity")
    void deveTestarConversaoDeProdutoResponseAPartirDeProdutoEntity() {

        ProdutoEntity produtoEntityMock = ProdutoEntityMock.builder().build();

        CriaProdutoResponse produtoResponseGerado =
                mapperServiceImpl.realizaCriacaoDeCriaProdutoResponseAPartirDeProdutoEntity(
                        produtoEntityMock
                );

        Assertions.assertNotNull(
                produtoResponseGerado.toString()
        );
    }
}
