package br.com.compras.modules.compras.actions.relatorio.service;

import br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse;

import java.time.LocalDate;

public interface RelatorioCompraService {

    RelatorioCompraResponse geraRelatorioDeComprasPorPeriodo(
            LocalDate dataInicialDoRelatorio,
            LocalDate dataFinalDoRelatorio
    );
}
