package br.com.compras.modules.compras.actions.pesquisa.service.mapper;

import br.com.compras.modules.compras.actions.pesquisa.dto.response.PesquisaCompraResponse;
import br.com.compras.modules.compras.entity.CompraEntity;

import java.util.List;

public interface PesquisaCompraMapperService {

    List<PesquisaCompraResponse> converteListaDeCompraEntityEmListaDePesquisaCompraResponse(
            List<CompraEntity> compraEntityList
    );
}
