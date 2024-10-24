package br.com.compras.modules.cliente.actions.cadastro.dto.response;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CriaClienteResponse {

    @Parameter(name = "Id do cliente", example = "74bcd515-655c-4def-8dc8-3329ccbdf62e")
    private UUID id;
}
