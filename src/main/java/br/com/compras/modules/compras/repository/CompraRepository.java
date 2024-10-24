package br.com.compras.modules.compras.repository;

import br.com.compras.modules.compras.entity.CompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
}
