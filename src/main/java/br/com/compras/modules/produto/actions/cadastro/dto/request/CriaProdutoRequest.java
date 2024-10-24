package br.com.compras.modules.produto.actions.cadastro.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CriaProdutoRequest {

    @JsonProperty("nome")
    @NotEmpty(message = "O nome do produto deve ser informado")
    @Parameter(name = "Nome do produto", example = "Bateria Moura 60AH", required = true)
    @Size(max = 60, message = "O nome do produto deve conter no máximo {max} caracteres")
    private String nome;
}
