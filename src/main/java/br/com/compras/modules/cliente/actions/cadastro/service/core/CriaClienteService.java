package br.com.compras.modules.cliente.actions.cadastro.service.core;

import br.com.compras.modules.cliente.actions.cadastro.dto.request.CriaClienteRequest;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.CriaClienteResponse;

public interface CriaClienteService {

    CriaClienteResponse realizaCadastroDoCliente(
            CriaClienteRequest criaClienteRequest
    );
}
