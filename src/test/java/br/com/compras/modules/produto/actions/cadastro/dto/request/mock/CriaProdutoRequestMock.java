package br.com.compras.modules.produto.actions.cadastro.dto.request.mock;

import br.com.compras.modules.produto.actions.cadastro.dto.request.CriaProdutoRequest;

public class CriaProdutoRequestMock {

    private CriaProdutoRequest criaProdutoRequest;

    private CriaProdutoRequestMock() {
    }

    public static CriaProdutoRequestMock builder() {

        CriaProdutoRequestMock builder = new CriaProdutoRequestMock();

        CriaProdutoRequest criaProduto = new CriaProdutoRequest();
        criaProduto.setNome("Liquidificador");

        builder.criaProdutoRequest = criaProduto;

        return builder;
    }

    public CriaProdutoRequest build() {
        return criaProdutoRequest;
    }
}
