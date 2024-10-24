package br.com.compras.modules.produto.actions.cadastro.dto.response.mock;

import br.com.compras.modules.produto.actions.cadastro.dto.response.CriaProdutoResponse;

import java.util.UUID;

public class CriaProdutoResponseMock {

    private CriaProdutoResponse criaProdutoResponse;

    private CriaProdutoResponseMock() {
    }

    public static CriaProdutoResponseMock builder() {

        CriaProdutoResponseMock builder = new CriaProdutoResponseMock();

        CriaProdutoResponse criaProduto = new CriaProdutoResponse();
        criaProduto.setId(UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"));

        builder.criaProdutoResponse = criaProduto;

        return builder;
    }

    public CriaProdutoResponse build() {
        return criaProdutoResponse;
    }
}
