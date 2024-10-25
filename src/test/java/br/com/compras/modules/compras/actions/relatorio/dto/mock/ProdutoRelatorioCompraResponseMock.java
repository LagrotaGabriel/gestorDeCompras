package br.com.compras.modules.compras.actions.relatorio.dto.mock;

import br.com.compras.modules.compras.actions.relatorio.dto.ProdutoRelatorioCompraResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRelatorioCompraResponseMock {

    private ProdutoRelatorioCompraResponse produtoRelatorioCompraResponse;

    private ProdutoRelatorioCompraResponseMock() {
    }

    public static ProdutoRelatorioCompraResponseMock builder() {

        ProdutoRelatorioCompraResponseMock builder = new ProdutoRelatorioCompraResponseMock();

        builder.produtoRelatorioCompraResponse =
                new ProdutoRelatorioCompraResponse(
                        "Impressora",
                        BigDecimal.valueOf(10000.0),
                        5L
                );

        return builder;
    }

    public ProdutoRelatorioCompraResponse build() {
        return produtoRelatorioCompraResponse;
    }

    public List<ProdutoRelatorioCompraResponse> buildList() {
        List<ProdutoRelatorioCompraResponse> pesquisaCompraResponseList = new ArrayList<>();
        pesquisaCompraResponseList.add(produtoRelatorioCompraResponse);

        return pesquisaCompraResponseList;
    }
}
