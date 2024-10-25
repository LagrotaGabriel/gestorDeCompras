package br.com.compras.modules.compras.actions.pesquisa.dto.request.mock;

import br.com.compras.modules.compras.actions.pesquisa.dto.request.PesquisaCompraRequest;

public class PesquisaCompraRequestMock {

    private PesquisaCompraRequest pesquisaCompraRequest;

    private PesquisaCompraRequestMock() {
    }

    public static PesquisaCompraRequestMock builder() {

        PesquisaCompraRequestMock builder = new PesquisaCompraRequestMock();

        PesquisaCompraRequest pesquisa = new PesquisaCompraRequest();
        pesquisa.setCpfCliente("472.535.279-22");
        pesquisa.setNomeProduto("Sanduicheira");

        builder.pesquisaCompraRequest = pesquisa;

        return builder;
    }

    public PesquisaCompraRequestMock comRangeDeData() {
        pesquisaCompraRequest.setRangeDataPesquisa(DataPesquisaCompraRequestMock.builder().build());
        return this;
    }

    public PesquisaCompraRequest build() {
        return pesquisaCompraRequest;
    }
}
