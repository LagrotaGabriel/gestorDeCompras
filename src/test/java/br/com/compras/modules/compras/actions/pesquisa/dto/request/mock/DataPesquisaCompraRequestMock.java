package br.com.compras.modules.compras.actions.pesquisa.dto.request.mock;

import br.com.compras.modules.compras.actions.pesquisa.dto.request.DataPesquisaCompraRequest;

public class DataPesquisaCompraRequestMock {

    private DataPesquisaCompraRequest dataPesquisaCompraRequest;

    private DataPesquisaCompraRequestMock() {
    }

    public static DataPesquisaCompraRequestMock builder() {

        DataPesquisaCompraRequestMock builder = new DataPesquisaCompraRequestMock();

        DataPesquisaCompraRequest pesquisa = new DataPesquisaCompraRequest();
        pesquisa.setDataInicio("2024-10-25");
        pesquisa.setDataFim("2024-10-25");

        builder.dataPesquisaCompraRequest = pesquisa;

        return builder;
    }

    public DataPesquisaCompraRequest build() {
        return dataPesquisaCompraRequest;
    }
}
