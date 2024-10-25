package br.com.compras.modules.compras.actions.relatorio.controller.impl;

import br.com.compras.modules.compras.actions.relatorio.controller.RelatorioCompraSwaggerController;
import br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse;
import br.com.compras.modules.compras.actions.relatorio.service.RelatorioCompraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * RelatorioCompraController
 * Esta classe fornece o endpoint necessário para acessar as regras de negócio referentes a pesquisa de compras
 *
 * @author Gabriel Lagrota
 * @since 25/10/2024
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/srv-compras/v1/compra/relatorio")
public class RelatorioCompraController implements RelatorioCompraSwaggerController {

    private final RelatorioCompraService relatorioCompraService;

    @Override
    @GetMapping
    public ResponseEntity<RelatorioCompraResponse> relatorioCompras(@Param("dataInicio") LocalDate dataInicio,
                                                                    @Param("dataFim") LocalDate dataFim) {

        log.info("Endpoint de relatorio de compras acessado");
        log.trace("dataInicio: {}", dataInicio);
        log.trace("dataFim: {}", dataFim);

        log.debug("Iniciando acesso ao service de relatorio de compras...");
        return ResponseEntity.status(HttpStatus.OK).body(
                relatorioCompraService.geraRelatorioDeComprasPorPeriodo(
                        dataInicio,
                        dataFim
                )
        );
    }
}
