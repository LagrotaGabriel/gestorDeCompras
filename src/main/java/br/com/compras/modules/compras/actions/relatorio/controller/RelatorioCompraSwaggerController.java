package br.com.compras.modules.compras.actions.relatorio.controller;

import br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface RelatorioCompraSwaggerController {

    @Tag(name = "Relatório de compras")
    @Operation(summary = "Esse endpoint tem como objetivo realizar a obtenção de relatórios de compras por período",
            method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Relatório de compras gerado com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RelatorioCompraResponse.class))}),
    })
    ResponseEntity<RelatorioCompraResponse> relatorioCompras(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim
    );
}
