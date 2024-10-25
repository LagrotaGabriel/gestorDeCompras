package br.com.compras.modules.compras.actions.pesquisa.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PesquisaCompraRequest {

    @JsonProperty("cpfCliente")
    @Parameter(name = "CPF do clienteutilizado na busca", example = "471")
    @Size(message = "O campo cpfCliente deverá possuir entre {min} e {max} caracteres", min = 3, max = 14)
    private String cpfCliente;

    @JsonProperty("nomeProduto")
    @Parameter(name = "Nome do produtoutilizado na busca", example = "GABR")
    @Size(message = "O campo nomeProduto deverá possuir entre {min} e {max} caracteres", min = 3, max = 60)
    private String nomeProduto;

    @Valid
    @JsonProperty("rangeDataPesquisa")
    @Parameter(name = "Range de datas da pesquisa")
    private DataPesquisaCompraRequest rangeDataPesquisa;
}
