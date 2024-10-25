package br.com.compras.modules.compras.actions.cadastro.services.core.impl;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.cliente.repository.dao.ClienteDAO;
import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.dto.response.CriaCompraResponse;
import br.com.compras.modules.compras.actions.cadastro.services.core.CriaCompraService;
import br.com.compras.modules.compras.actions.cadastro.services.mapper.CriaCompraMapperService;
import br.com.compras.modules.compras.actions.cadastro.services.validator.CriaCompraValidatorService;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.compras.repository.dao.CompraDAO;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.repository.dao.ProdutoDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriaCompraServiceImpl implements CriaCompraService {

    private final CriaCompraValidatorService criaCompraValidatorService;
    private final CriaCompraMapperService criaCompraMapperService;

    private final CompraDAO compraDAO;
    private final ProdutoDAO produtoDAO;
    private final ClienteDAO clienteDAO;

    @Override
    public CriaCompraResponse realizaCadastroDeCompra(CriaCompraRequest criaCompraRequest) {

        log.debug("Metodo de servico responsavel por executar logica de criacao de nova compra acessado");
        log.trace("criaCompraRequest: {}", criaCompraRequest);

        log.debug("Iniciando acesso ao metodo responsavel por obter produto por nome no banco de dados...");
        ProdutoEntity produtoReferenciado = produtoDAO.buscaPorNome(criaCompraRequest.getNomeProduto());
        log.debug("Acesso ao metodo responsavel por obter produto por nome no banco de dados finalizado");
        log.trace("produtoReferenciado: {}", produtoReferenciado);

        log.debug("Iniciando acesso ao metodo responsavel por obter cliente por cpf no banco de dados...");
        ClienteEntity clienteReferenciado = clienteDAO.buscaPorCpf(criaCompraRequest.getCpfComprador());
        log.debug("Acesso ao metodo responsavel por obter cliente por cpf no banco de dados finalizado");
        log.trace("clienteReferenciado: {}", clienteReferenciado);

        log.debug("Iniciando acesso ao metodo de conversao de CompraEntity a partir de CriaCompraRequest...");
        CompraEntity compraGerada =
                criaCompraMapperService.realizaConversaoDeCompraEntityAPartirDeCriaCompraRequest(
                        criaCompraRequest,
                        produtoReferenciado,
                        clienteReferenciado
                );
        log.debug("Acesso ao metodo de conversao de CompraEntity a partir de CriaCompraRequest finalizado");
        log.trace("compraGerada: {}", compraGerada);

        log.debug("Iniciando acesso ao metodo responsavel por realizar as validacoes de negocio da compra...");
        criaCompraValidatorService.realizaValidacoesDeNegocioDoCadastroDaCompra(
                criaCompraRequest,
                compraGerada
        );
        log.debug("Acesso ao metodo responsavel por realizar as validacoes de negocio da compra finalizado");

        log.debug("Iniciando acesso ao metodo responsavel por implementar a persistencia da compra no banco de dados...");
        CompraEntity compraPersistida =
                compraDAO.persisteEntidade(
                        compraGerada
                );
        log.debug("Acesso ao metodo responsavel por implementar a persistencia da compra no banco de dados finalizado");
        log.trace("compraPersistida: {}", compraPersistida);

        log.debug("Iniciando acesso ao metodo de conversao de CriaClienteResponse a partir de CompraEntity...");
        CriaCompraResponse criaCompraResponse =
                criaCompraMapperService.realizaConversaoDeCriaCompraResponseAPartirDeCompraEntity(
                        compraPersistida
                );
        log.debug("Acesso ao metodo de conversao de CriaCompraResponse a partir de CompraEntity finalizado");
        log.trace("criaCompraResponse: {}", criaCompraResponse);

        log.info("Criacao de nova compra realizada com sucesso");
        return criaCompraResponse;

    }
}
