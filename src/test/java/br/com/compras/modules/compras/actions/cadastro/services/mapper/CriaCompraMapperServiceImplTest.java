package br.com.compras.modules.compras.actions.cadastro.services.mapper;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.cliente.entity.mock.ClienteEntityMock;
import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.dto.request.mock.CriaCompraRequestMock;
import br.com.compras.modules.compras.actions.cadastro.dto.response.CriaCompraResponse;
import br.com.compras.modules.compras.actions.cadastro.services.mapper.impl.CriaCompraMapperServiceImpl;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.compras.entity.mock.CompraEntityMock;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.entity.mock.ProdutoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("MapperService: CriaCompra")
class CriaCompraMapperServiceImplTest {

    @InjectMocks
    CriaCompraMapperServiceImpl mapperServiceImpl;

    @Test
    @DisplayName("Deve testar conversao de CompraEntity a partir de CriaCompraRequest")
    void deveTestarConversaoDeCompraEntityAPartirDeCriaCompraRequest() {

        CriaCompraRequest criaCompraRequestMock = CriaCompraRequestMock.builder().build();
        ProdutoEntity produtoEntityMock = ProdutoEntityMock.builder().build();
        ClienteEntity clienteEntityMock = ClienteEntityMock.builder().build();

        CompraEntity compraEntityGerada =
                mapperServiceImpl.realizaConversaoDeCompraEntityAPartirDeCriaCompraRequest(
                        criaCompraRequestMock,
                        produtoEntityMock,
                        clienteEntityMock
                );

        Assertions.assertNotNull(
                compraEntityGerada.toString()
        );
    }

    @Test
    @DisplayName("Deve testar conversao de CriaCompraResponse a partir de CompraEntity")
    void deveTestarConversaoDeCompraResponseAPartirDeCompraEntity() {

        CompraEntity compraEntityMock = CompraEntityMock.builder().build();

        CriaCompraResponse compraResponseGerada =
                mapperServiceImpl.realizaConversaoDeCriaCompraResponseAPartirDeCompraEntity(
                        compraEntityMock
                );

        Assertions.assertNotNull(
                compraResponseGerada.toString()
        );
    }
}
