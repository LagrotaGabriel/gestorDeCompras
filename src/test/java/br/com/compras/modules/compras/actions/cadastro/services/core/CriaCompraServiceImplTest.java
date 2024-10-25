package br.com.compras.modules.compras.actions.cadastro.services.core;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.cliente.entity.mock.ClienteEntityMock;
import br.com.compras.modules.cliente.repository.dao.ClienteDAO;
import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.dto.request.mock.CriaCompraRequestMock;
import br.com.compras.modules.compras.actions.cadastro.dto.response.CriaCompraResponse;
import br.com.compras.modules.compras.actions.cadastro.dto.response.mock.CriaCompraResponseMock;
import br.com.compras.modules.compras.actions.cadastro.services.core.impl.CriaCompraServiceImpl;
import br.com.compras.modules.compras.actions.cadastro.services.mapper.CriaCompraMapperService;
import br.com.compras.modules.compras.actions.cadastro.services.validator.CriaCompraValidatorService;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.compras.entity.mock.CompraEntityMock;
import br.com.compras.modules.compras.repository.dao.CompraDAO;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.entity.mock.ProdutoEntityMock;
import br.com.compras.modules.produto.repository.dao.ProdutoDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Service: CriaCompra")
class CriaCompraServiceImplTest {

    @InjectMocks
    CriaCompraServiceImpl criaCompraServiceImpl;

    @Mock
    CriaCompraValidatorService criaCompraValidatorService;

    @Mock
    CriaCompraMapperService criaCompraMapperService;

    @Mock
    CompraDAO compraDAO;

    @Mock
    ProdutoDAO produtoDAO;

    @Mock
    ClienteDAO clienteDAO;

    @Test
    @DisplayName("Deve testar cadastro de compra")
    void deveTestarCadastroDeCompra() {

        ProdutoEntity produtoEntityMock = ProdutoEntityMock.builder().build();
        ClienteEntity clienteEntityMock = ClienteEntityMock.builder().build();
        CompraEntity compraEntityMock = CompraEntityMock.builder().build();
        CriaCompraRequest criaCompraRequestMock = CriaCompraRequestMock.builder().build();
        CriaCompraResponse criaCompraResponse = CriaCompraResponseMock.builder().build();

        when(produtoDAO.buscaPorNome(any()))
                .thenReturn(produtoEntityMock);

        when(clienteDAO.buscaPorCpf(any()))
                .thenReturn(clienteEntityMock);

        when(criaCompraMapperService.realizaConversaoDeCompraEntityAPartirDeCriaCompraRequest(any(), any(), any()))
                .thenReturn(compraEntityMock);

        doNothing().when(criaCompraValidatorService)
                .realizaValidacoesDeNegocioDoCadastroDaCompra(criaCompraRequestMock, compraEntityMock);

        when(compraDAO.persisteEntidade(any())).thenReturn(compraEntityMock);

        when(criaCompraMapperService.realizaConversaoDeCriaCompraResponseAPartirDeCompraEntity(any()))
                .thenReturn(criaCompraResponse);

        CriaCompraResponse retornoMetodo =
                criaCompraServiceImpl.realizaCadastroDeCompra(
                        criaCompraRequestMock
                );

        Assertions.assertEquals(
                "CriaCompraResponse(id=cf004916-9faa-4b6f-9178-dd781644cdee)",
                retornoMetodo.toString()
        );
    }
}
