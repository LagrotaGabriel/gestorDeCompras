package br.com.compras.modules.compras.repository;

import br.com.compras.modules.compras.actions.relatorio.dto.ProdutoRelatorioCompraResponse;
import br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse;
import br.com.compras.modules.compras.entity.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface CompraRepository extends JpaRepository<CompraEntity, UUID> {

    @Query("SELECT COALESCE(SUM(c.quantidade), 0) " +
            "FROM CompraEntity c " +
            "WHERE c.produto.id = ?1 " +
            "AND c.cliente.id = ?2")
    Integer realizaContagemDeQuantosProdutosForamAdquiridosPeloCliente(
            UUID idProdutoAdquirido,
            UUID idClienteComprador
    );

    @Query(value = "SELECT c FROM CompraEntity c " +
            "WHERE (:buscaPorCpfCliente IS NULL OR UPPER(c.cliente.cpf) LIKE %:buscaPorCpfCliente%) " +
            "AND (:buscaPorNomeProduto IS NULL OR UPPER(c.produto.nome) LIKE %:buscaPorNomeProduto%) " +
            "AND ((:dataInicioBusca IS NULL AND :dataFimBusca IS NULL) OR (c.dataHoraCadastro BETWEEN :dataInicioBusca AND :dataFimBusca))"
    )
    List<CompraEntity> pesquisaCompras(
            @Param("buscaPorCpfCliente") String buscaPorCpfCliente,
            @Param("buscaPorNomeProduto") String buscaPorNomeProduto,
            @Param("dataInicioBusca") LocalDateTime dataInicioBusca,
            @Param("dataFimBusca") LocalDateTime dataFimBusca
    );

    @Query("SELECT new br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse" +
            "(" +
            "COUNT(c), " +
            "COALESCE(SUM(c.quantidade), 0), " +
            "COALESCE(SUM(c.valorUnitario * c.quantidade), 0), " +
            "NULL" +
            ") " +
            "FROM CompraEntity c " +
            "WHERE ((:dataInicioBusca IS NULL AND :dataFimBusca IS NULL) OR (c.dataHoraCadastro BETWEEN :dataInicioBusca AND :dataFimBusca))"
    )
    RelatorioCompraResponse obtemCalculosDeRelatorioDeCompras(
            @Param("dataInicioBusca") LocalDateTime dataInicioBusca,
            @Param("dataFimBusca") LocalDateTime dataFimBusca
    );

    @Query("SELECT new br.com.compras.modules.compras.actions.relatorio.dto.ProdutoRelatorioCompraResponse" +
            "(" +
            "UPPER(c.produto.nome), " +
            "COALESCE(SUM(c.valorUnitario * c.quantidade), 0), " +
            "COALESCE(SUM(c.quantidade), 0)" +
            ") " +
            "FROM CompraEntity c " +
            "WHERE ((:dataInicioBusca IS NULL AND :dataFimBusca IS NULL) OR (c.dataHoraCadastro BETWEEN :dataInicioBusca AND :dataFimBusca)) " +
            "GROUP BY c.produto.nome " +
            "ORDER BY c.produto.nome DESC")
    List<ProdutoRelatorioCompraResponse> obtemLevantamentoDeDadosDeComprasPorProduto(
            @Param("dataInicioBusca") LocalDateTime dataInicioBusca,
            @Param("dataFimBusca") LocalDateTime dataFimBusca
    );
}
