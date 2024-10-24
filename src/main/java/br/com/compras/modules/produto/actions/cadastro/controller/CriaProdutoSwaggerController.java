package br.com.compras.modules.produto.actions.cadastro.controller;

import br.com.compras.modules.produto.actions.cadastro.dto.request.CriaProdutoRequest;
import br.com.compras.modules.produto.actions.cadastro.dto.response.CriaProdutoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CriaProdutoSwaggerController {

    @Tag(name = "Cadastro de novo produto")
    @Operation(summary = "Esse endpoint tem como objetivo realizar o cadastro de um novo produto",
            method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Produto criado com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CriaProdutoResponse.class))})
    })
    ResponseEntity<CriaProdutoResponse> criaNovoProduto(
            @Valid @RequestBody CriaProdutoRequest criaProdutoRequest
    );
}
