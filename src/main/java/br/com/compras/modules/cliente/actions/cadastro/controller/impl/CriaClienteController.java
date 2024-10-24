package br.com.compras.modules.cliente.actions.cadastro.controller.impl;

import br.com.compras.modules.cliente.actions.cadastro.controller.CriaClienteSwaggerController;
import br.com.compras.modules.cliente.actions.cadastro.dto.request.CriaClienteRequest;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.CriaClienteResponse;
import br.com.compras.modules.cliente.actions.cadastro.service.core.CriaClienteService;
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
 * CriaClienteController
 * Esta classe fornece o endpoint necessário para acessar as regras de negócio referentes ao cadastro de um novo cliente
 *
 * @author Gabriel Lagrota
 * @since 24/10/2024
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-compras/v1/cliente")
public class CriaClienteController implements CriaClienteSwaggerController {

    private final CriaClienteService criaClienteService;

    @Override
    @PostMapping
    public ResponseEntity<CriaClienteResponse> criaNovoCliente(@Valid @RequestBody CriaClienteRequest criacaoClienteRequest) {

        log.info("Endpoint de cadastro clientes acessado");
        log.trace("criacaoClienteRequest: {}", criacaoClienteRequest);

        log.debug("Iniciando acesso ao service de cadastro de clientes...");
        return ResponseEntity.status(HttpStatus.CREATED).body(
                criaClienteService.realizaCadastroDoCliente(
                        criacaoClienteRequest
                )
        );
    }
}
