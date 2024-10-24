package br.com.compras.modules.produto.actions.cadastro.service.mapper.impl;

import br.com.compras.modules.produto.actions.cadastro.dto.request.CriaProdutoRequest;
import br.com.compras.modules.produto.actions.cadastro.dto.response.CriaProdutoResponse;
import br.com.compras.modules.produto.actions.cadastro.service.mapper.CriaProdutoMapperService;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CriaProdutoMapperServiceImpl implements CriaProdutoMapperService {

    @Override
    public ProdutoEntity realizaCriacaoDeProdutoEntityAPartirDeCriaProdutoRequest(CriaProdutoRequest criaProdutoRequest) {

        log.debug("Mapper responsavel por converter CriaProdutoRequest em ProdutoEntity acessado");
        log.trace("criaProdutoRequest: {}", criaProdutoRequest);

        log.debug("Iniciando criacao de objeto do tipo ProdutoEntity...");
        ProdutoEntity produtoEntity =
                ProdutoEntity.builder()
                        .id(UUID.randomUUID())
                        .nome(criaProdutoRequest.getNome())
                        .build();
        log.debug("Criacao de objeto do tipo ProdutoEntity realizada com sucesso");
        log.trace("produtoEntity: {}", produtoEntity);

        log.debug("Retornando objeto produtoEntity criado...");
        return produtoEntity;
    }

    @Override
    public CriaProdutoResponse realizaCriacaoDeCriaProdutoResponseAPartirDeProdutoEntity(ProdutoEntity produtoEntity) {

        log.debug("Mapper responsavel por converter ProdutoEntity em CriaProdutoResponse acessado");
        log.trace("criaProdutoResponse: {}", produtoEntity);

        log.debug("Iniciando criacao de objeto do tipo CriaProdutoResponse...");
        CriaProdutoResponse criaProdutoResponse =
                CriaProdutoResponse.builder()
                        .id(produtoEntity.getId())
                        .build();
        log.debug("Criacao de objeto do tipo criaProdutoResponse realizada com sucesso");
        log.trace("criaProdutoResponse: {}", criaProdutoResponse);

        log.debug("Retornando objeto criaProdutoResponse criado...");
        return criaProdutoResponse;
    }
}
