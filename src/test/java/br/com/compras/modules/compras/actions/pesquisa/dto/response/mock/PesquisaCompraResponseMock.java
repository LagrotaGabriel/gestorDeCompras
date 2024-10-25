package br.com.compras.modules.compras.actions.pesquisa.dto.response.mock;

import br.com.compras.modules.compras.actions.pesquisa.dto.response.PesquisaCompraResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PesquisaCompraResponseMock {

    private PesquisaCompraResponse pesquisaCompraResponse;

    private PesquisaCompraResponseMock() {
    }

    public static PesquisaCompraResponseMock builder() {

        PesquisaCompraResponseMock builder = new PesquisaCompraResponseMock();

        PesquisaCompraResponse pesquisa = new PesquisaCompraResponse();
        pesquisa.setId(UUID.fromString("98355f25-bcb7-43f3-a2f0-8ce15bf910ca"));
        pesquisa.setDataHoraCadastro(LocalDateTime.of(2024, 10, 25, 0, 38, 0));
        pesquisa.setQuantidade(1);
        pesquisa.setValorUnitario(BigDecimal.valueOf(10.0));
        pesquisa.setValorTotal(BigDecimal.valueOf(10.0));
        pesquisa.setNomeProduto("Impressora");
        pesquisa.setNomeCliente("Adailton");
        pesquisa.setCpfCliente("888.888.888-88");

        builder.pesquisaCompraResponse = pesquisa;

        return builder;
    }

    public PesquisaCompraResponse build() {
        return pesquisaCompraResponse;
    }

    public List<PesquisaCompraResponse> buildList() {

        List<PesquisaCompraResponse> pesquisaCompraResponseList = new ArrayList<>();
        pesquisaCompraResponseList.add(pesquisaCompraResponse);

        return pesquisaCompraResponseList;
    }
}
