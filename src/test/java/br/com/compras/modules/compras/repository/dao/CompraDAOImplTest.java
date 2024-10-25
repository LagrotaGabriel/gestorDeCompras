package br.com.compras.modules.compras.repository.dao;

import br.com.compras.modules.compras.actions.relatorio.dto.ProdutoRelatorioCompraResponse;
import br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse;
import br.com.compras.modules.compras.actions.relatorio.dto.mock.ProdutoRelatorioCompraResponseMock;
import br.com.compras.modules.compras.actions.relatorio.dto.mock.RelatorioCompraResponseMock;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.compras.entity.mock.CompraEntityMock;
import br.com.compras.modules.compras.repository.CompraRepository;
import br.com.compras.modules.compras.repository.dao.impl.CompraDAOImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("DAO: Compra")
class CompraDAOImplTest {

    @InjectMocks
    CompraDAOImpl compraDAOImpl;

    @Mock
    CompraRepository compraRepository;

    @Test
    @DisplayName("Deve testar implementação de persistência de compra")
    void deveTestarImplementacaoDePersistenciaDeCompra() {

        CompraEntity compraEntityMock = CompraEntityMock.builder().build();

        when(compraRepository.save(any())).thenReturn(compraEntityMock);

        CompraEntity compraEntityPersistido = compraDAOImpl.persisteEntidade(compraEntityMock);

        Assertions.assertEquals(
                "CompraEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, dataHoraCadastro=2024-10-24T16:35, quantidade=1, valorUnitario=100.0)",
                compraEntityPersistido.toString()
        );
    }

    @Test
    @DisplayName("Deve testar implementação de contagem de quantidade de produtos adquiridos pelo cliente")
    void deveTestarImplementacaoDeContagemDeQuantidadeDeProdutosAdquiridosPeloCliente() {

        when(compraRepository.realizaContagemDeQuantosProdutosForamAdquiridosPeloCliente(any(), any())).thenReturn(1);

        Integer quantidadeDeProdutosPorIdAdquiridosPeloCliente =
                compraDAOImpl.realizaContagemDaQuantidadeDeProdutosPorIdAdquiridosPeloCliente(
                        UUID.fromString("cf004916-9faa-4b6f-9178-dd781644cdee"),
                        UUID.fromString("cf004916-9faa-4b6f-9178-dd781644cdee")
                );

        Assertions.assertEquals(
                1,
                quantidadeDeProdutosPorIdAdquiridosPeloCliente
        );
    }

    @Test
    @DisplayName("Deve testar pesquisa de compras")
    void deveTestarPesquisaDeCompras() {

        List<CompraEntity> compraEntityMockList = CompraEntityMock.builder().buildList();

        when(compraRepository.pesquisaCompras(any(), any(), any(), any())).thenReturn(compraEntityMockList);

        List<CompraEntity> retornoRepositorio =
                compraDAOImpl.realizaPesquisa(
                        null,
                        null,
                        null,
                        null
                );

        Assertions.assertEquals(
                "[CompraEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, dataHoraCadastro=2024-10-24T16:35, " +
                        "quantidade=1, valorUnitario=100.0)]",
                retornoRepositorio.toString()
        );
    }

    @Test
    @DisplayName("Deve testar obtenção de cálculos de relatórios de compras")
    void deveTestarObtencaoDeCalculosDeRelatorioDeCompras() {

        RelatorioCompraResponse relatorioCompraResponseMock = RelatorioCompraResponseMock.builder().build();

        when(compraRepository.obtemCalculosDeRelatorioDeCompras(any(), any())).thenReturn(relatorioCompraResponseMock);

        RelatorioCompraResponse retornoChamada =
                compraDAOImpl.obtemCalculosDeRelatorioDeCompras(
                        LocalDateTime.of(2024, 10, 20, 0, 0),
                        LocalDateTime.of(2024, 10, 25, 0, 0)
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
    @DisplayName("Deve testar obtenção de levantamento de dados de compras por produto")
    void deveTestarObtencaoDeLevantamentoDeDadosDeComprasPorProduto() {

        List<ProdutoRelatorioCompraResponse> produtoRelatorioCompraResponseList = ProdutoRelatorioCompraResponseMock.builder().buildList();

        when(compraRepository.obtemLevantamentoDeDadosDeComprasPorProduto(any(), any())).thenReturn(produtoRelatorioCompraResponseList);

        List<ProdutoRelatorioCompraResponse> retornoChamada =
                compraDAOImpl.obtemLevantamentoDeDadosDeComprasPorProduto(
                        LocalDateTime.of(2024, 10, 20, 0, 0),
                        LocalDateTime.of(2024, 10, 25, 0, 0)
                );

        Assertions.assertEquals(
                "[ProdutoRelatorioCompraResponse(nomeProduto=Impressora, valorTotalVendido=10000.0, quantidadeTotalVendida=5)]",
                retornoChamada.toString()
        );
    }
}
