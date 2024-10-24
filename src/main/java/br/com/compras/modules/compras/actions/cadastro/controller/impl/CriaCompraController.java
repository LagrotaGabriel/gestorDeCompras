package br.com.compras.modules.compras.actions.cadastro.controller.impl;

import br.com.compras.modules.compras.actions.cadastro.controller.CriaCompraSwaggerController;
import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.dto.response.CriaCompraResponse;
import br.com.compras.modules.compras.actions.cadastro.services.core.CriaCompraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CriaCompraController
 * Esta classe fornece o endpoint necessário para acessar as regras de negócio referentes ao cadastro de uma nova compra
 *
 * @author Gabriel Lagrota
 * @since 24/10/2024
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-compras/v1/compra")
public class CriaCompraController implements CriaCompraSwaggerController {

    private final CriaCompraService criaCompraService;

    @Override
    @PostMapping
    public ResponseEntity<CriaCompraResponse> criaNovaCompra(@Valid @RequestBody CriaCompraRequest criaCompraRequest) {

        log.info("Endpoint de cadastro de nova compra acessado");
        log.trace("criaCompraRequest: {}", criaCompraRequest);

        log.debug("Iniciando acesso ao service de cadastro de nova compra...");
        return ResponseEntity.status(HttpStatus.CREATED).body(
                criaCompraService.realizaCadastroDeCompra(
                        criaCompraRequest
                )
        );
    }
}
