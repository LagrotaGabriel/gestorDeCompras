package br.com.compras.modules.cliente.actions.cadastro.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CriaClienteRequest {

    @JsonProperty("cpf")
    @NotEmpty(message = "O CPF do cliente deverá ser informado")
    @Parameter(name = "CPF do cliente", example = "472.545.279-22", required = true)
    @Size(message = "O CPF do cliente deverá possuir {max} caracteres", max = 14, min = 14)
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF informado é inválido. Use um padrão válido. Exemplo: 111.111.111-11")
    private String cpf;

    @JsonProperty("nome")
    @NotEmpty(message = "O nome do cliente deverá ser informado")
    @Parameter(name = "Nome do cliente", example = "Gabriel Lagrota", required = true)
    @Size(max = 60, message = "O nome do cliente deve conter no máximo {max} caracteres")
    private String nome;
}
