package br.com.compras.modules.produto.actions.cadastro.service.mapper;

import br.com.compras.modules.produto.actions.cadastro.dto.request.CriaProdutoRequest;
import br.com.compras.modules.produto.actions.cadastro.dto.response.CriaProdutoResponse;
import br.com.compras.modules.produto.entity.ProdutoEntity;

public interface CriaProdutoMapperService {

    ProdutoEntity realizaCriacaoDeProdutoEntityAPartirDeCriaProdutoRequest(
            CriaProdutoRequest criaProdutoRequest
    );

    CriaProdutoResponse realizaCriacaoDeCriaProdutoResponseAPartirDeProdutoEntity(
            ProdutoEntity produtoEntity
    );
}
