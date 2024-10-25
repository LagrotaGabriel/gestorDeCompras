package br.com.compras.modules.compras.actions.cadastro.services.mapper;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.dto.response.CriaCompraResponse;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.produto.entity.ProdutoEntity;

public interface CriaCompraMapperService {

    CompraEntity realizaConversaoDeCompraEntityAPartirDeCriaCompraRequest(
            CriaCompraRequest criaCompraRequest,
            ProdutoEntity produtoReferenciado,
            ClienteEntity clienteReferenciado
    );

    CriaCompraResponse realizaConversaoDeCriaCompraResponseAPartirDeCompraEntity(
            CompraEntity compraEntity
    );
}
