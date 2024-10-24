package br.com.compras.modules.produto.actions.cadastro.dto.response;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CriaProdutoResponse {

    @Parameter(name = "Id do produto", example = "74bcd515-655c-4def-8dc8-3329ccbdf62e")
    private UUID id;
}
