package br.com.compras.modules.compras.actions.pesquisa.controller;

import br.com.compras.modules.compras.actions.pesquisa.dto.request.PesquisaCompraRequest;
import br.com.compras.modules.compras.actions.pesquisa.dto.response.PesquisaCompraResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PesquisaCompraSwaggerController {

    @Tag(name = "Pesquisa de compras")
    @Operation(summary = "Esse endpoint tem como objetivo realizar a pesquisa de compras",
            method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Pesquisa realizada com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PesquisaCompraResponse.class))}),
    })
    ResponseEntity<List<PesquisaCompraResponse>> pesquisaCompras(
            @Valid @RequestBody PesquisaCompraRequest pesquisaCompraRequest
    );
}
