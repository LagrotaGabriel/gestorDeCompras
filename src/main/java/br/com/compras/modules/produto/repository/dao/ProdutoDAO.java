package br.com.compras.modules.produto.repository.dao;

import br.com.compras.modules.produto.entity.ProdutoEntity;

public interface ProdutoDAO {

    ProdutoEntity persisteEntidade(
            ProdutoEntity produtoEntity
    );
}
