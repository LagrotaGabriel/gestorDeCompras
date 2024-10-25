package br.com.compras.modules.compras.actions.relatorio.service.impl;

import br.com.compras.modules.compras.actions.relatorio.dto.ProdutoRelatorioCompraResponse;
import br.com.compras.modules.compras.actions.relatorio.dto.RelatorioCompraResponse;
import br.com.compras.modules.compras.actions.relatorio.service.RelatorioCompraService;
import br.com.compras.modules.compras.repository.dao.CompraDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RelatorioCompraServiceImpl implements RelatorioCompraService {

    private final CompraDAO compraDAO;

    @Override
    public RelatorioCompraResponse geraRelatorioDeComprasPorPeriodo(LocalDate dataInicialDoRelatorio,
                                                                    LocalDate dataFinalDoRelatorio) {

        log.debug("Metodo de servico responsavel por executar a logica de geracao de relatorio de compras acessado");
        log.trace("dataInicialDoRelatorio: {}", dataInicialDoRelatorio);
        log.trace("dataFinalDoRelatorio: {}", dataFinalDoRelatorio);

        log.debug("Iniciando tratamento da data de inicio da busca...");
        LocalDateTime dataInicioTratada =
                (dataInicialDoRelatorio == null || dataFinalDoRelatorio == null)
                        ? null
                        : LocalDateTime.of(dataInicialDoRelatorio, LocalTime.of(0, 0));
        log.debug("Tratamento da data de inicio da busca finalizado");
        log.trace("dataInicioTratada: {}", dataInicioTratada);

        log.debug("Iniciando tratamento da data final da busca...");
        LocalDateTime dataFimTratada =
                (dataInicialDoRelatorio == null || dataFinalDoRelatorio == null)
                        ? null
                        : LocalDateTime.of(dataFinalDoRelatorio, LocalTime.of(23, 59));
        log.debug("Tratamento da data final da busca finalizado");
        log.trace("dataFimTratada: {}", dataFimTratada);

        log.debug("Iniciando acesso ao metodo responsavel por implementar a pesquisa de compras no banco de dados...");
        RelatorioCompraResponse relatorioCompraResponse =
                compraDAO.obtemCalculosDeRelatorioDeCompras(
                        dataInicioTratada,
                        dataFimTratada
                );
        log.debug("Acesso ao metodo responsavel por implementar a pesquisa de relatorio de compras no banco de dados finalizado");
        log.trace("relatorioCompraResponse: {}", relatorioCompraResponse);

        log.debug("Iniciando acesso ao metodo responsavel por implementar a pesquisa de relatorio individual por produto no banco de dados...");
        List<ProdutoRelatorioCompraResponse> produtoRelatorioCompraResponseList =
                compraDAO.obtemLevantamentoDeDadosDeComprasPorProduto(
                        dataInicioTratada,
                        dataFimTratada
                );
        log.debug("Acesso ao metodo responsavel por implementar a pesquisa de relatorio individual por produto no banco de dados finalizado");
        log.trace("produtoRelatorioCompraResponseList: {}", produtoRelatorioCompraResponseList);

        log.debug("Setando a lista de relatorios por produto no objeto RelatorioCompraResponse...");
        relatorioCompraResponse.setProdutosRelatorio(produtoRelatorioCompraResponseList);
        log.debug("Lista de relatorios por produto no objeto RelatorioCompraResponse setado");
        log.trace("relatorioCompraResponse: {}", relatorioCompraResponse);

        log.info("Relatorio gerado com sucesso");
        return relatorioCompraResponse;
    }
}
