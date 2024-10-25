package br.com.compras.modules.compras.actions.cadastro.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CriaCompraRequest {

    @JsonProperty("quantidade")
    @NotNull(message = "A quantidade de produtos adquiridos deverá ser informada")
    @Min(message = "A quantidade de produtos adquiridos não pode ser menor do que {value}", value = 1)
    @Max(message = "A quantidade de produtos adquiridos não pode ser maior do que {value}", value = 3)
    @Parameter(name = "Quantidade mínima ideal do produto em estoque", example = "5", required = true)
    private Integer quantidade;

    @JsonProperty("valorUnitario")
    @NotNull(message = "O valor unitário do produto deverá ser informado")
    @Parameter(name = "Valor unitário do produto vendido", example = "5.00", required = true)
    @Min(message = "O campo valor unitário não pode ser menor do que {value}", value = 1)
    @Max(message = "O campo valor unitário não pode ser maior do que {value}", value = 100000000)
    private BigDecimal valorUnitario;

    @JsonProperty("nomeProduto")
    @NotEmpty(message = "O nome do produto deverá ser informado")
    @Parameter(name = "Nome do produto", example = "Bateria Moura 60AH", required = true)
    @Size(max = 60, message = "O nome do produto deverá conter no máximo {max} caracteres")
    private String nomeProduto;

    @JsonProperty("cpfComprador")
    @Parameter(name = "CPF do comprador", example = "472.545.279-22")
    @Size(message = "O CPF do comprador deverá possuir {max} caracteres", min = 14, max = 14)
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF do comprador informado é inválido. Use um padrão válido. Exemplo: 111.111.111-11")
    private String cpfComprador;
}