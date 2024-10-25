package br.com.compras.modules.compras.actions.cadastro.services.validator.impl;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.services.validator.CriaCompraValidatorService;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.compras.exceptions.ProdutoAdquiridoNaoLocalizadoException;
import br.com.compras.modules.compras.exceptions.QuantidadeMaximaDeProdutosAdquiridosExcedidaException;
import br.com.compras.modules.compras.repository.dao.CompraDAO;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriaCompraValidatorServiceImpl implements CriaCompraValidatorService {

    private final CompraDAO compraDAO;

    @Override
    public void realizaValidacoesDeNegocioDoCadastroDaCompra(CriaCompraRequest criaCompraRequest,
                                                             CompraEntity compraGerada) {

        log.debug("Metodo de validacao responsavel por realizar as chamadas para as validacoes do cadastro de compras acessado");
        log.trace("compraGerada: {}", compraGerada);

        validaSeAlgumClienteFoiEncontradoAtravesDoCpfInformado(
                criaCompraRequest.getCpfComprador(),
                compraGerada.getCliente()
        );

        validaSeAlgumProdutoFoiEncontradoAtravesDoNomeInformado(
                compraGerada.getProduto()
        );

        validaSeClienteIraExcederLimiteDeComprasDoProduto(
                compraGerada.getQuantidade(),
                compraGerada.getProduto(),
                compraGerada.getCliente()
        );

        log.debug("Metodo de validacao responsavel por realizar as chamadas para as validacoes do cadastro de compras finalizado");
    }

    @Override
    public void validaSeAlgumClienteFoiEncontradoAtravesDoCpfInformado(String cpf,
                                                                       ClienteEntity clienteEncontrado) {

        // Dadas as regras de negócio da aplicação, informar um cliente no cadastro da compranão é obrigatório, mas...
        // caso seja informado, é obrigatório que um cliente seja localizado. Caso contrário é lançada uma Exception.

        log.debug("Metodo de validacao responsavel por validar se algum cliente foi encontrado atraves do CPF informado acessado");
        log.trace("cpf: {}", cpf);
        log.trace("clienteEncontrado: {}", clienteEncontrado);

        if (ObjectUtils.isEmpty(cpf)) {
            log.debug("Como nenhum cpf foi informado na requisicao de cadastro de compra, essa validacao sera retornada prematuramente...");
            return;
        }

        if (clienteEncontrado == null) {
            log.warn("Nenhum cliente foi localizado atraves do CPF informado");
            throw new ProdutoAdquiridoNaoLocalizadoException(
                    "Nenhum cliente foi localizado através do CPF informado. Digite outro CPF e tente novamente."
            );
        }

    }

    @Override
    public void validaSeAlgumProdutoFoiEncontradoAtravesDoNomeInformado(ProdutoEntity produto) {

        // Importante ressaltar que dado o fluxo da aplicação, é obrigatório que um produto seja encontrado

        log.debug("Metodo de validacao responsavel por validar se algum produto foi encontrado atraves do nome informado acessado");
        log.trace("produto: {}", produto);

        if (produto == null) {
            log.warn("Nenhum produto foi localizado atraves do nome informado");
            throw new ProdutoAdquiridoNaoLocalizadoException(
                    "Nenhum produto foi localizado através da nomenclatura informada. Digite outro nome de produto e tente novamente."
            );
        }

        log.debug("Metodo de validacao responsavel por validar se algum produto foi encontrado atraves do nome informado finalizado");

    }

    @Override
    public void validaSeClienteIraExcederLimiteDeComprasDoProduto(Integer quantidadeDoProdutoAdquirida,
                                                                  ProdutoEntity produtoAdquirido,
                                                                  ClienteEntity clienteComprador) {

        log.debug("Metodo de validacao responsavel por validar se cliente ira exceder limite de compras do produto acessado");
        log.trace("produtoAdquirido: {}", produtoAdquirido);
        log.trace("cliente: {}", clienteComprador);

        if (clienteComprador == null) {
            log.debug("Como nenhum cliente foi referenciado na compra, a validacao sera finalizada prematuramente...");
            return;
        }

        log.debug("Iniciando acesso ao metodo responsavel por implementar a consulta no banco de dados da quantidade de " +
                "produtos por id adquiridos pelo cliente...");
        Integer quantidadeDeProdutosPorIdAdquiridosPeloCliente =
                compraDAO.realizaContagemDaQuantidadeDeProdutosPorIdAdquiridosPeloCliente(
                        produtoAdquirido.getId(),
                        clienteComprador.getId()
                );
        log.debug("Acesso ao metodo responsavel por implementar a consulta no banco de dados da quantidade de " +
                "produtos por id adquiridos pelo cliente finalizado");
        log.trace("quantidadeDeProdutosPorIdAdquiridosPeloCliente: {}", quantidadeDeProdutosPorIdAdquiridosPeloCliente);

        if ((quantidadeDeProdutosPorIdAdquiridosPeloCliente + quantidadeDoProdutoAdquirida) > 3) {
            log.warn("Quantidade maxima de produtos adquiridos excedida");
            throw new QuantidadeMaximaDeProdutosAdquiridosExcedidaException(
                    "A quantidade atual de produtos obtidos pelo cliente excede o limite permitido. (Máximo: 3 produtos por CPF)"
            );
        }

        log.debug("Metodo de validacao responsavel por validar se cliente ira exceder limite de compras do produto finalizado");
    }
}
