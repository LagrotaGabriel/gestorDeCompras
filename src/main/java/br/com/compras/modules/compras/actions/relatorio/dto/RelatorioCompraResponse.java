package br.com.compras.modules.compras.actions.relatorio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
public class RelatorioCompraResponse {

    @JsonProperty("quantidadeTotalDeComprasRealizadas")
    @Parameter(name = "Quantidade total de compras realizadas no período do relatório")
    Long quantidadeTotalDeComprasRealizadas;

    @JsonProperty("quantidadeTotalDeProdutosAdquiridos")
    @Parameter(name = "Quantidade total de produtos adquiridos no período do relatório")
    Long quantidadeTotalDeProdutosAdquiridos;

    @JsonProperty("valorTotalCompras")
    @Parameter(name = "Valor total realizado em compras no período do relatório")
    BigDecimal valorTotalCompras;

    @JsonProperty("produtosRelatorio")
    @Parameter(name = "Lista de relatório individual por produto vendido")
    List<ProdutoRelatorioCompraResponse> produtosRelatorio;

    public RelatorioCompraResponse(Long quantidadeTotalDeComprasRealizadas,
                                   Long quantidadeTotalDeProdutosAdquiridos,
                                   BigDecimal valorTotalCompras,
                                   List<ProdutoRelatorioCompraResponse> produtosRelatorio) {

        this.quantidadeTotalDeComprasRealizadas = quantidadeTotalDeComprasRealizadas;
        this.quantidadeTotalDeProdutosAdquiridos = quantidadeTotalDeProdutosAdquiridos;
        this.valorTotalCompras = valorTotalCompras;
        this.produtosRelatorio = produtosRelatorio;
    }
}
