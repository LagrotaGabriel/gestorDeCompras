package br.com.compras.modules.produto.actions.cadastro.controller.impl;

import br.com.compras.modules.produto.actions.cadastro.controller.CriaProdutoSwaggerController;
import br.com.compras.modules.produto.actions.cadastro.dto.request.CriaProdutoRequest;
import br.com.compras.modules.produto.actions.cadastro.dto.response.CriaProdutoResponse;
import br.com.compras.modules.produto.actions.cadastro.service.core.CriaProdutoService;
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
 * CriaProdutoController
 * Esta classe fornece o endpoint necessário para acessar as regras de negócio referentes ao cadastro de um novo produto
 *
 * @author Gabriel Lagrota
 * @since 23/10/2024
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-compras/v1/produto")
public class CriaProdutoController implements CriaProdutoSwaggerController {

    private final CriaProdutoService criaProdutoService;

    @Override
    @PostMapping
    public ResponseEntity<CriaProdutoResponse> criaNovoProduto(@Valid @RequestBody CriaProdutoRequest criacaoClienteRequest) {

        log.info("Endpoint de cadastro de novo produto acessado");
        log.trace("criacaoClienteRequest: {}", criacaoClienteRequest);

        log.debug("Iniciando acesso ao service de cadastro de novo produto...");
        return ResponseEntity.status(HttpStatus.CREATED).body(
                criaProdutoService.realizaCriacaoDeUmNovoProduto(
                        criacaoClienteRequest
                )
        );
    }
}
