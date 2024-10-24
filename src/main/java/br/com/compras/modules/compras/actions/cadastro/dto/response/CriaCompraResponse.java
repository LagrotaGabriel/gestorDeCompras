package br.com.compras.modules.compras.actions.cadastro.dto.response;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CriaCompraResponse {

    @Parameter(name = "Id da compra", example = "74bcd515-655c-4def-8dc8-3329ccbdf62e")
    private UUID idCompra;
}