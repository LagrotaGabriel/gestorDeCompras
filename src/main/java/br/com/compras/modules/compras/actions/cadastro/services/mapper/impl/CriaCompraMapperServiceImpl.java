package br.com.compras.modules.compras.actions.cadastro.services.mapper.impl;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.dto.response.CriaCompraResponse;
import br.com.compras.modules.compras.actions.cadastro.services.mapper.CriaCompraMapperService;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class CriaCompraMapperServiceImpl implements CriaCompraMapperService {

    @Override
    public CompraEntity realizaConversaoDeCompraEntityAPartirDeCriaCompraRequest(CriaCompraRequest criaCompraRequest,
                                                                                 ProdutoEntity produtoReferenciado,
                                                                                 ClienteEntity clienteReferenciado) {

        log.debug("Mapper responsavel por converter CriaCompraRequest em CompraEntity acessado");
        log.trace("criaCompraRequest: {}", criaCompraRequest);

        log.debug("Iniciando criacao de objeto do tipo CompraEntity...");
        CompraEntity compraEntity =
                CompraEntity.builder()
                        .id(UUID.randomUUID())
                        .dataHoraCadastro(LocalDateTime.now())
                        .quantidade(criaCompraRequest.getQuantidade())
                        .valorUnitario(criaCompraRequest.getValorUnitario())
                        .produto(produtoReferenciado)
                        .cliente(clienteReferenciado)
                        .build();
        log.debug("Criacao de objeto do tipo CompraEntity realizada com sucesso");
        log.trace("compraEntity: {}", compraEntity);

        log.debug("Retornando objeto compraEntity criado...");
        return compraEntity;
    }

    @Override
    public CriaCompraResponse realizaConversaoDeCriaCompraResponseAPartirDeCompraEntity(CompraEntity compraEntity) {

        log.debug("Mapper responsavel por converter CompraEntity em CriaCompraResponse acessado");
        log.trace("compraResponse: {}", compraEntity);

        log.debug("Iniciando criacao de objeto do tipo CriaCompraResponse...");
        CriaCompraResponse compraResponse =
                CriaCompraResponse.builder()
                        .id(compraEntity.getId())
                        .build();
        log.debug("Criacao de objeto do tipo CriaCompraResponse realizada com sucesso");
        log.trace("compraResponse: {}", compraResponse);

        log.debug("Retornando objeto compraResponse criado...");
        return compraResponse;
    }
}
