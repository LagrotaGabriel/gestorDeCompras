package br.com.compras.modules.compras.actions.relatorio.service;

import br.com.compras.modules.compras.actions.relatorio.dto.ProdutoRelatorioCompraResponse;
import br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse;
import br.com.compras.modules.compras.actions.relatorio.dto.mock.ProdutoRelatorioCompraResponseMock;
import br.com.compras.modules.compras.actions.relatorio.dto.mock.RelatorioCompraResponseMock;
import br.com.compras.modules.compras.actions.relatorio.service.impl.RelatorioCompraServiceImpl;
import br.com.compras.modules.compras.repository.dao.CompraDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("ServiceImpl: RelatorioCompra")
class RelatorioCompraServiceImplTest {

    @InjectMocks
    RelatorioCompraServiceImpl relatorioCompraServiceImpl;

    @Mock
    CompraDAO compraDAO;

    @Test
    @DisplayName("Deve testar geracao de relatorio de compras com datas informadas")
    void deveTestarGeracaoDeRelatorioDeComprasComDatasInformadas() {

        RelatorioCompraResponse relatorioCompraResponseMock = RelatorioCompraResponseMock.builder().build();
        List<ProdutoRelatorioCompraResponse> produtoRelatorioCompraResponseList = ProdutoRelatorioCompraResponseMock.builder().buildList();

        when(compraDAO.obtemCalculosDeRelatorioDeCompras(any(), any())).thenReturn(relatorioCompraResponseMock);
        when(compraDAO.obtemLevantamentoDeDadosDeComprasPorProduto(any(), any())).thenReturn(produtoRelatorioCompraResponseList);

        RelatorioCompraResponse retornoChamada =
                relatorioCompraServiceImpl.geraRelatorioDeComprasPorPeriodo(
                        LocalDate.of(2024, 10, 20),
                        LocalDate.of(2024, 10, 25)
                );

        Assertions.assertEquals(
                "RelatorioCompraResponse(quantidadeTotalDeComprasRealizadas=5, " +
                        "quantidadeTotalDeProdutosAdquiridos=5, valorTotalCompras=10000.0, " +
                        "produtosRelatorio=[ProdutoRelatorioCompraResponse(nomeProduto=Impressora, " +
                        "valorTotalVendido=10000.0, quantidadeTotalVendida=5)])",
                retornoChamada.toString()
        );
    }

    @Test
    @DisplayName("Deve testar geracao de relatorio de compras sem datas informadas")
    void deveTestarGeracaoDeRelatorioDeComprasSemDatasInformadas() {

        RelatorioCompraResponse relatorioCompraResponseMock = RelatorioCompraResponseMock.builder().build();
        List<ProdutoRelatorioCompraResponse> produtoRelatorioCompraResponseList = ProdutoRelatorioCompraResponseMock.builder().buildList();

        when(compraDAO.obtemCalculosDeRelatorioDeCompras(any(), any())).thenReturn(relatorioCompraResponseMock);
        when(compraDAO.obtemLevantamentoDeDadosDeComprasPorProduto(any(), any())).thenReturn(produtoRelatorioCompraResponseList);

        RelatorioCompraResponse retornoChamada =
                relatorioCompraServiceImpl.geraRelatorioDeComprasPorPeriodo(
                        null,
                        null
                );

        Assertions.assertEquals(
                "RelatorioCompraResponse(quantidadeTotalDeComprasRealizadas=5, " +
                        "quantidadeTotalDeProdutosAdquiridos=5, valorTotalCompras=10000.0, " +
                        "produtosRelatorio=[ProdutoRelatorioCompraResponse(nomeProduto=Impressora, " +
                        "valorTotalVendido=10000.0, quantidadeTotalVendida=5)])",
                retornoChamada.toString()
        );
    }
}
