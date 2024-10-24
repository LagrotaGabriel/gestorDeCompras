package br.com.compras.modules.cliente.actions.cadastro.controller;

import br.com.compras.modules.cliente.actions.cadastro.dto.request.CriaClienteRequest;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.CriaClienteResponse;
import br.com.compras.modules.cliente.actions.cadastro.exceptions.CpfDoClienteJaExisteException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CriaClienteSwaggerController {

    @Tag(name = "Cadastro de novo cliente")
    @Operation(summary = "Esse endpoint tem como objetivo realizar o cadastro de um novo cliente",
            method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Cliente criado com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CriaClienteResponse.class))}),
            @ApiResponse(responseCode = "400",
                    description = "O CPF enviado já existe",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CpfDoClienteJaExisteException.class))}),
    })
    ResponseEntity<CriaClienteResponse> criaNovoCliente(
            @Valid @RequestBody CriaClienteRequest criaClienteRequest
    );
}
