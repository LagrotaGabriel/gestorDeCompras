package br.com.compras.modules.compras.actions.pesquisa.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DataPesquisaCompraRequest {

    @JsonProperty("dataInicio")
    @Parameter(name = "Data de inicio da busca", example = "2024-05-31")
    @NotEmpty(message = "Caso a pesquisa por range de data seja informada, a data de inicio é obrigatória")
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",
            message = "O padrão enviado para a data de início da busca é inválido. Utilize o padrão yyyy-MM-dd. Exemplo: 2024-10-24"
    )
    private String dataInicio;

    @JsonProperty("dataFim")
    @NotEmpty(message = "Caso a pesquisa por range de data seja informada, a data de término da busca é obrigatória")
    @Parameter(name = "Data de término da busca", example = "2024-05-31")
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",
            message = "O padrão enviado para a data de término da busca é inválido. Utilize o padrão yyyy-MM-dd. Exemplo: 2024-10-24"
    )
    private String dataFim;
}
