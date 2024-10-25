package br.com.compras.modules.compras.actions.pesquisa.service.mapper.impl;

import br.com.compras.modules.compras.actions.pesquisa.dto.response.PesquisaCompraResponse;
import br.com.compras.modules.compras.actions.pesquisa.service.mapper.PesquisaCompraMapperService;
import br.com.compras.modules.compras.entity.CompraEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PesquisaCompraMapperServiceImpl implements PesquisaCompraMapperService {

    @Override
    public List<PesquisaCompraResponse> converteListaDeCompraEntityEmListaDePesquisaCompraResponse(List<CompraEntity> compraEntityList) {

        log.debug("Mapper responsavel por converter lista de CompraEntity em lista de PesquisaCompraResponse acessado");
        log.trace("compraEntityList: {}", compraEntityList);

        List<PesquisaCompraResponse> pesquisaCompraResponseList = new ArrayList<>();

        log.debug("Iniciando iteracao pela lista de compraEntityList...");
        for (CompraEntity compraEntity : compraEntityList) {

            log.trace("Item iterado: {}", compraEntity);

            log.debug("Iniciando criacao de objeto do tipo CompraEntity...");
            PesquisaCompraResponse pesquisaCompraResponse =
                    PesquisaCompraResponse.builder()
                            .id(compraEntity.getId())
                            .dataHoraCadastro(compraEntity.getDataHoraCadastro())
                            .quantidade(compraEntity.getQuantidade())
                            .valorUnitario(compraEntity.getValorUnitario())
                            .valorTotal(compraEntity.getValorUnitario().multiply(BigDecimal.valueOf(compraEntity.getQuantidade())))
                            .nomeProduto(compraEntity.getProduto().getNome())
                            .nomeCliente(
                                    (compraEntity.getCliente() != null)
                                            ? compraEntity.getCliente().getNome()
                                            : null
                            )
                            .cpfCliente(
                                    (compraEntity.getCliente() != null)
                                            ? compraEntity.getCliente().getCpf()
                                            : null
                            )
                            .build();
            log.debug("Criacao de objeto do tipo PesquisaCompraResponse realizada com sucesso");
            log.trace("pesquisaCompraResponse: {}", pesquisaCompraResponse);

            log.debug("Adicionando objeto criado na lista de PesquisaCompraResponse...");
            pesquisaCompraResponseList.add(pesquisaCompraResponse);
            log.debug("Adicao a lista realizada com sucesso");
            log.trace("pesquisaCompraResponseList: {}", pesquisaCompraResponseList);

            log.debug("Iteracao do item finalizada");
        }

        log.debug("Iteracao da lista de CompraEntity finalizada");

        log.debug("Retornando lista de objetos do tipo PesquisaCompraResponse criado...");
        return pesquisaCompraResponseList;
    }
}
