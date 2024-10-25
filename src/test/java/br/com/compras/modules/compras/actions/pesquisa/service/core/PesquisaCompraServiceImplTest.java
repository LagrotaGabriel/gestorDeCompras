package br.com.compras.modules.compras.actions.pesquisa.service.core;

import br.com.compras.modules.compras.actions.pesquisa.dto.request.PesquisaCompraRequest;
import br.com.compras.modules.compras.actions.pesquisa.dto.request.mock.PesquisaCompraRequestMock;
import br.com.compras.modules.compras.actions.pesquisa.dto.response.PesquisaCompraResponse;
import br.com.compras.modules.compras.actions.pesquisa.dto.response.mock.PesquisaCompraResponseMock;
import br.com.compras.modules.compras.actions.pesquisa.service.core.impl.PesquisaCompraServiceImpl;
import br.com.compras.modules.compras.actions.pesquisa.service.mapper.PesquisaCompraMapperService;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.compras.entity.mock.CompraEntityMock;
import br.com.compras.modules.compras.repository.dao.CompraDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Service: PesquisaCompra")
class PesquisaCompraServiceImplTest {

    @InjectMocks
    PesquisaCompraServiceImpl pesquisaCompraServiceImpl;

    @Mock
    CompraDAO compraDAO;

    @Mock
    PesquisaCompraMapperService pesquisaCompraMapperService;

    @Test
    @DisplayName("Deve testar pesquisa de compras com parametros preenchidos")
    void deveTestarPesquisaDeComprasComParametrosPreenchidos() {

        PesquisaCompraRequest pesquisaCompraRequestMock = PesquisaCompraRequestMock.builder().comRangeDeData().build();
        List<CompraEntity> compraEntityList = CompraEntityMock.builder().buildList();
        List<PesquisaCompraResponse> pesquisaCompraResponseList = PesquisaCompraResponseMock.builder().buildList();

        when(compraDAO.realizaPesquisa(any(), any(), any(), any())).thenReturn(compraEntityList);
        when(pesquisaCompraMapperService.converteListaDeCompraEntityEmListaDePesquisaCompraResponse(any())).thenReturn(pesquisaCompraResponseList);

        List<PesquisaCompraResponse> respostaServico =
                pesquisaCompraServiceImpl.pesquisaCompras(
                        pesquisaCompraRequestMock
                );

        Assertions.assertEquals(
                "[PesquisaCompraResponse(id=98355f25-bcb7-43f3-a2f0-8ce15bf910ca, " +
                        "dataHoraCadastro=2024-10-25T00:38, quantidade=1, valorUnitario=10.0, valorTotal=10.0, " +
                        "nomeProduto=Impressora, nomeCliente=Adailton, cpfCliente=888.888.888-88)]",
                respostaServico.toString()
        );
    }

    @Test
    @DisplayName("Deve testar pesquisa de compras com parametros vazios")
    void deveTestarPesquisaDeComprasComParametrosVazios() {

        PesquisaCompraRequest pesquisaCompraRequestMock = new PesquisaCompraRequest();
        List<CompraEntity> compraEntityList = CompraEntityMock.builder().buildList();
        List<PesquisaCompraResponse> pesquisaCompraResponseList = PesquisaCompraResponseMock.builder().buildList();

        when(compraDAO.realizaPesquisa(any(), any(), any(), any())).thenReturn(compraEntityList);
        when(pesquisaCompraMapperService.converteListaDeCompraEntityEmListaDePesquisaCompraResponse(any())).thenReturn(pesquisaCompraResponseList);

        List<PesquisaCompraResponse> respostaServico =
                pesquisaCompraServiceImpl.pesquisaCompras(
                        pesquisaCompraRequestMock
                );

        Assertions.assertEquals(
                "[PesquisaCompraResponse(id=98355f25-bcb7-43f3-a2f0-8ce15bf910ca, " +
                        "dataHoraCadastro=2024-10-25T00:38, quantidade=1, valorUnitario=10.0, valorTotal=10.0, " +
                        "nomeProduto=Impressora, nomeCliente=Adailton, cpfCliente=888.888.888-88)]",
                respostaServico.toString()
        );
    }
}
