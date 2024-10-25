package br.com.compras.modules.compras.actions.pesquisa.service.mapper;

import br.com.compras.modules.compras.actions.pesquisa.dto.response.PesquisaCompraResponse;
import br.com.compras.modules.compras.actions.pesquisa.service.mapper.impl.PesquisaCompraMapperServiceImpl;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.compras.entity.mock.CompraEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("MapperService: PesquisaCompra")
class PesquisaCompraMapperServiceImplTest {

    @InjectMocks
    PesquisaCompraMapperServiceImpl mapperServiceImpl;

    @Test
    @DisplayName("Deve testar conversao de lista de CompraEntity em lista de PesquisaCompraResponse")
    void deveTestarconversaoDeListaDeCompraEntityEmListaDePesquisaCompraResponse() {

        List<CompraEntity> compraEntityMockList = CompraEntityMock.builder().comProduto().buildList();

        List<PesquisaCompraResponse> pesquisaCompraResponseList =
                mapperServiceImpl.converteListaDeCompraEntityEmListaDePesquisaCompraResponse(
                        compraEntityMockList
                );

        Assertions.assertNotNull(
                pesquisaCompraResponseList.toString()
        );
    }

    @Test
    @DisplayName("Deve testar conversao de lista de CompraEntity em lista de PesquisaCompraResponse com cliente")
    void deveTestarconversaoDeListaDeCompraEntityEmListaDePesquisaCompraResponseComCliente() {

        List<CompraEntity> compraEntityMockList = CompraEntityMock.builder().comProduto().comCliente().buildList();

        List<PesquisaCompraResponse> pesquisaCompraResponseList =
                mapperServiceImpl.converteListaDeCompraEntityEmListaDePesquisaCompraResponse(
                        compraEntityMockList
                );

        Assertions.assertNotNull(
                pesquisaCompraResponseList.toString()
        );
    }
}
