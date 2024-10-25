package br.com.compras.modules.compras.actions.relatorio.dto.mock;

import br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse;

import java.math.BigDecimal;

public class RelatorioCompraResponseMock {

    private RelatorioCompraResponse relatorioCompraResponse;

    private RelatorioCompraResponseMock() {
    }

    public static RelatorioCompraResponseMock builder() {

        RelatorioCompraResponseMock builder = new RelatorioCompraResponseMock();

        builder.relatorioCompraResponse =
                new RelatorioCompraResponse(
                        5L,
                        5L,
                        BigDecimal.valueOf(10000.0),
                        ProdutoRelatorioCompraResponseMock.builder().buildList()
                );

        return builder;
    }

    public RelatorioCompraResponse build() {
        return relatorioCompraResponse;
    }
}
