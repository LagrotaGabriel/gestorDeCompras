package br.com.compras.modules.compras.actions.pesquisa.service.core;

import br.com.compras.modules.compras.actions.pesquisa.dto.request.PesquisaCompraRequest;
import br.com.compras.modules.compras.actions.pesquisa.dto.response.PesquisaCompraResponse;

import java.util.List;

public interface PesquisaCompraService {

    List<PesquisaCompraResponse> pesquisaCompras(
      PesquisaCompraRequest pesquisaCompraRequest
    );
}
