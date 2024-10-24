package br.com.compras.modules.compras.actions.cadastro.controller;

import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.dto.response.CriaCompraResponse;
import br.com.compras.modules.compras.exceptions.ClienteNaoLocalizadoException;
import br.com.compras.modules.compras.exceptions.ProdutoAdquiridoNaoLocalizadoException;
import br.com.compras.modules.compras.exceptions.QuantidadeMaximaDeProdutosAdquiridosExcedidaException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CriaCompraSwaggerController {

    @Tag(name = "Cadastro de nova compra")
    @Operation(summary = "Esse endpoint tem como objetivo realizar o cadastro de uma nova compra",
            method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Compra criada com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CriaCompraResponse.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Nenhum cliente foi localizado através do CPF informado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteNaoLocalizadoException.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Nenhum produto foi localizado através do nome informado",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoAdquiridoNaoLocalizadoException.class))}),
            @ApiResponse(responseCode = "400",
                    description = "A quantidade máxima de produtos adquiridos para o CPF do cliente foi excedida",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = QuantidadeMaximaDeProdutosAdquiridosExcedidaException.class))}),
    })
    ResponseEntity<CriaCompraResponse> criaNovaCompra(
            @Valid @RequestBody CriaCompraRequest criaCompraRequest
    );
}
