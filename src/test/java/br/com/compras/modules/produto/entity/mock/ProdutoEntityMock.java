package br.com.compras.modules.produto.entity.mock;

import br.com.compras.modules.produto.entity.ProdutoEntity;

import java.util.UUID;

public class ProdutoEntityMock {

    private ProdutoEntity produtoEntity;

    private ProdutoEntityMock() {
    }

    public static ProdutoEntityMock builder() {

        ProdutoEntityMock builder = new ProdutoEntityMock();

        ProdutoEntity produto = new ProdutoEntity();
        produto.setId(UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"));
        produto.setNome("Batedeira");

        builder.produtoEntity = produto;

        return builder;
    }

    public ProdutoEntity build() {
        return produtoEntity;
    }
}
