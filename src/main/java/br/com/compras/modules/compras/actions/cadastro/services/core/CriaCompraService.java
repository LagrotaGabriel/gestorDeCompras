package br.com.compras.modules.compras.actions.cadastro.services.core;

import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.dto.response.CriaCompraResponse;

public interface CriaCompraService {

    CriaCompraResponse realizaCadastroDeCompra(
            CriaCompraRequest criaCompraRequest
    );
}
