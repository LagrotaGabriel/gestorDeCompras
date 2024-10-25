package br.com.compras.modules.compras.repository.dao;

import br.com.compras.modules.compras.actions.relatorio.dto.ProdutoRelatorioCompraResponse;
import br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse;
import br.com.compras.modules.compras.entity.CompraEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface CompraDAO {

    CompraEntity persisteEntidade(
            CompraEntity compraEntity
    );

    Integer realizaContagemDaQuantidadeDeProdutosPorIdAdquiridosPeloCliente(
            UUID idProdutoAdquirido,
            UUID idClienteComprador
    );

    List<CompraEntity> realizaPesquisa(
            String buscaPorCpfCliente,
            String buscaPorNomeProduto,
            LocalDateTime dataInicio,
            LocalDateTime dataFim
    );

    RelatorioCompraResponse obtemCalculosDeRelatorioDeCompras(
            LocalDateTime dataInicioRelatorio,
            LocalDateTime dataFimRelatorio
    );

    List<ProdutoRelatorioCompraResponse> obtemLevantamentoDeDadosDeComprasPorProduto(
            LocalDateTime dataInicioRelatorioProduto,
            LocalDateTime dataFimRelatorioProduto
    );
}
