package br.com.compras.modules.cliente.actions.cadastro.service.mapper;

import br.com.compras.modules.cliente.actions.cadastro.dto.request.CriaClienteRequest;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.CriaClienteResponse;
import br.com.compras.modules.cliente.entity.ClienteEntity;

public interface CriaClienteMapperService {

    ClienteEntity realizaCriacaoDeClienteEntityAPartirDeCriaClienteRequest(
            CriaClienteRequest criaClienteRequest
    );

    CriaClienteResponse realizaCriacaoDeCriaClienteResponseAPartirDeClienteEntity(
            ClienteEntity clienteEntity
    );
}
