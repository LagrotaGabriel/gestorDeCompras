package br.com.compras.modules.compras.repository;

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

    @Query("SELECT COUNT(c) FROM CompraEntity c " +
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
}
