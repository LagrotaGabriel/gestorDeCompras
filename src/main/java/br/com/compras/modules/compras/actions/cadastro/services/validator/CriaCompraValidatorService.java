package br.com.compras.modules.compras.actions.cadastro.services.validator;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.produto.entity.ProdutoEntity;

public interface CriaCompraValidatorService {

    void realizaValidacoesDeNegocioDoCadastroDaCompra(
            CriaCompraRequest criaCompraRequest,
            CompraEntity compraGerada
    );

    void validaSeAlgumClienteFoiEncontradoAtravesDoCpfInformado(
            String cpf,
            ClienteEntity clienteEncontrado
    );

    void validaSeAlgumProdutoFoiEncontradoAtravesDoNomeInformado(
            ProdutoEntity produto
    );

    void validaSeClienteIraExcederLimiteDeComprasDoProduto(
            Integer quantidadeDoProdutoAdquirida,
            ProdutoEntity produtoAdquirido,
            ClienteEntity clienteComprador
    );
}
