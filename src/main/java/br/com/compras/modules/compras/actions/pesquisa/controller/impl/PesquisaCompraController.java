package br.com.compras.modules.compras.actions.pesquisa.controller.impl;

import br.com.compras.modules.compras.actions.pesquisa.controller.PesquisaCompraSwaggerController;
import br.com.compras.modules.compras.actions.pesquisa.dto.request.PesquisaCompraRequest;
import br.com.compras.modules.compras.actions.pesquisa.dto.response.PesquisaCompraResponse;
import br.com.compras.modules.compras.actions.pesquisa.service.core.PesquisaCompraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * PesquisaCompraController
 * Esta classe fornece o endpoint necessário para acessar as regras de negócio referentes a pesquisa de compras
 *
 * @author Gabriel Lagrota
 * @since 24/10/2024
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-compras/v1/compra/pesquisa")
public class PesquisaCompraController implements PesquisaCompraSwaggerController {

    private final PesquisaCompraService pesquisaCompraService;

    @Override
    @PostMapping
    public ResponseEntity<List<PesquisaCompraResponse>> pesquisaCompras(@Valid @RequestBody PesquisaCompraRequest pesquisaCompraRequest) {

        log.info("Endpoint de pesquisa de compras acessado");
        log.trace("pesquisaCompraRequest: {}", pesquisaCompraRequest);

        log.debug("Iniciando acesso ao service de pesquisa de compras...");
        return ResponseEntity.status(HttpStatus.OK).body(
                pesquisaCompraService.pesquisaCompras(
                        pesquisaCompraRequest
                )
        );
    }

}
