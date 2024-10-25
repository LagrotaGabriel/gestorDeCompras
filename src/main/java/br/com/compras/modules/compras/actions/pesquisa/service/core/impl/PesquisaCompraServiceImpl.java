package br.com.compras.modules.compras.actions.pesquisa.service.core.impl;

import br.com.compras.modules.compras.actions.pesquisa.dto.request.PesquisaCompraRequest;
import br.com.compras.modules.compras.actions.pesquisa.dto.response.PesquisaCompraResponse;
import br.com.compras.modules.compras.actions.pesquisa.service.core.PesquisaCompraService;
import br.com.compras.modules.compras.actions.pesquisa.service.mapper.PesquisaCompraMapperService;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.compras.repository.dao.CompraDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PesquisaCompraServiceImpl implements PesquisaCompraService {

    private final CompraDAO compraDAO;
    private final PesquisaCompraMapperService pesquisaCompraMapperService;

    @Override
    public List<PesquisaCompraResponse> pesquisaCompras(PesquisaCompraRequest pesquisaCompraRequest) {

        log.debug("Metodo de servico responsavel por executar a logica de pesquisa de compras acessado");
        log.trace("pesquisaCompraRequest: {}", pesquisaCompraRequest);

        log.debug("Iniciando tratamento do cpf do cliente recebido...");
        String cpfClienteTratado =
                (ObjectUtils.isEmpty(pesquisaCompraRequest.getCpfCliente()))
                        ? null
                        : pesquisaCompraRequest.getCpfCliente().toUpperCase();
        log.debug("Tratamento do cpf do clienterecebido finalizado");
        log.trace("cpfClienteTratado: {}", cpfClienteTratado);

        log.debug("Iniciando tratamento do nome do produto recebido...");
        String nomeProdutoTratado =
                (ObjectUtils.isEmpty(pesquisaCompraRequest.getNomeProduto()))
                        ? null
                        : pesquisaCompraRequest.getNomeProduto().toUpperCase();
        log.debug("Tratamento do nome do produto recebido finalizado");
        log.trace("nomeProdutoTratado: {}", nomeProdutoTratado);

        log.debug("Iniciando tratamento da data de inicio da busca...");
        LocalDateTime dataInicioTratada =
                (pesquisaCompraRequest.getRangeDataPesquisa() == null)
                        ? null
                        : LocalDateTime.parse(pesquisaCompraRequest.getRangeDataPesquisa().getDataInicio() + "T00:00:00");
        log.debug("Tratamento da data de inicio da busca finalizado");
        log.trace("dataInicioTratada: {}", dataInicioTratada);

        log.debug("Iniciando tratamento da data final da busca...");
        LocalDateTime dataFimTratada =
                (pesquisaCompraRequest.getRangeDataPesquisa() == null)
                        ? null
                        : LocalDateTime.parse(pesquisaCompraRequest.getRangeDataPesquisa().getDataFim() + "T00:00:00").plusDays(1L);
        log.debug("Tratamento da data final da busca finalizado");
        log.trace("dataFimTratada: {}", dataFimTratada);

        log.debug("Iniciando acesso ao metodo responsavel por implementar a pesquisa de compras no banco de dados...");
        List<CompraEntity> comprasEncontradas =
                compraDAO.realizaPesquisa(
                        cpfClienteTratado,
                        nomeProdutoTratado,
                        dataInicioTratada,
                        dataFimTratada
                );
        log.debug("Acesso ao metodo responsavel por implementar a pesquisa de compras no banco de dados finalizado");
        log.trace("comprasEncontradas: {}", comprasEncontradas);

        log.debug("Iniciando acesso ao metodo de conversao de lista de CompraEntity para lista de PesquisaCompraResponse...");
        List<PesquisaCompraResponse> pesquisaCompraResponseList =
                pesquisaCompraMapperService.converteListaDeCompraEntityEmListaDePesquisaCompraResponse(
                        comprasEncontradas
                );
        log.debug("Acesso ao metodo de conversao de lista de CompraEntity para lista de PesquisaCompraResponse finalizado");
        log.trace("pesquisaCompraResponseList: {}", pesquisaCompraResponseList);

        log.info("Pesquisa de compras realizada com sucesso");
        return pesquisaCompraResponseList;
    }
}
