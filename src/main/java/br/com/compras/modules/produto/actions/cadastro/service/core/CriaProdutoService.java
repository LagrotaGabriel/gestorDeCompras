package br.com.compras.modules.produto.actions.cadastro.service.core;

import br.com.compras.modules.produto.actions.cadastro.dto.request.CriaProdutoRequest;
import br.com.compras.modules.produto.actions.cadastro.dto.response.CriaProdutoResponse;

public interface CriaProdutoService {

    CriaProdutoResponse realizaCriacaoDeUmNovoProduto(
            CriaProdutoRequest criaProdutoRequest
    );
}
