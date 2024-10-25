package br.com.compras.modules.compras.repository.dao;

import br.com.compras.modules.compras.entity.CompraEntity;

import java.util.UUID;

public interface CompraDAO {

    CompraEntity persisteEntidade(
            CompraEntity compraEntity
    );

    Integer realizaContagemDaQuantidadeDeProdutosPorIdAdquiridosPeloCliente(
            UUID idProdutoAdquirido,
            UUID idClienteComprador
    );
}
