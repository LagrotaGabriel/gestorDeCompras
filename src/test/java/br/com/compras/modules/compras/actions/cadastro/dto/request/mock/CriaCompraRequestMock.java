package br.com.compras.modules.compras.actions.cadastro.dto.request.mock;

import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;

import java.math.BigDecimal;

public class CriaCompraRequestMock {

    private CriaCompraRequest criaCompraRequest;

    private CriaCompraRequestMock() {
    }

    public static CriaCompraRequestMock builder() {

        CriaCompraRequestMock builder = new CriaCompraRequestMock();

        CriaCompraRequest compra = new CriaCompraRequest();
        compra.setQuantidade(1);
        compra.setValorUnitario(BigDecimal.valueOf(100.0));
        compra.setCpfComprador("472.535.279-22");
        compra.setNomeProduto("Sanduicheira");

        builder.criaCompraRequest = compra;

        return builder;
    }

    public CriaCompraRequest build() {
        return criaCompraRequest;
    }
}
