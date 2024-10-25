package br.com.compras.modules.compras.actions.cadastro.dto.response.mock;

import br.com.compras.modules.compras.actions.cadastro.dto.response.CriaCompraResponse;

import java.util.UUID;

public class CriaCompraResponseMock {

    private CriaCompraResponse criaCompraResponse;

    private CriaCompraResponseMock() {
    }

    public static CriaCompraResponseMock builder() {

        CriaCompraResponseMock builder = new CriaCompraResponseMock();

        CriaCompraResponse compra = new CriaCompraResponse();
        compra.setId(UUID.fromString("cf004916-9faa-4b6f-9178-dd781644cdee"));

        builder.criaCompraResponse = compra;

        return builder;
    }

    public CriaCompraResponse build() {
        return criaCompraResponse;
    }
}
