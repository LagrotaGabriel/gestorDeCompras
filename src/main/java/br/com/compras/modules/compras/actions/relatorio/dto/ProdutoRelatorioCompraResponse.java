package br.com.compras.modules.compras.actions.relatorio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
public class ProdutoRelatorioCompraResponse {

    private String nomeProduto;
    private BigDecimal valorTotalVendido;
    private Long quantidadeTotalVendida;

    public ProdutoRelatorioCompraResponse(String nomeProduto,
                                          BigDecimal valorTotalVendido,
                                          Long quantidadeTotalVendida) {

        this.nomeProduto = nomeProduto;
        this.valorTotalVendido = valorTotalVendido;
        this.quantidadeTotalVendida = quantidadeTotalVendida;
    }
}
