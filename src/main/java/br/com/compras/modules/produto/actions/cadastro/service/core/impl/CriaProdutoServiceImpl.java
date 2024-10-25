package br.com.compras.modules.produto.actions.cadastro.service.core.impl;

import br.com.compras.modules.produto.actions.cadastro.dto.request.CriaProdutoRequest;
import br.com.compras.modules.produto.actions.cadastro.dto.response.CriaProdutoResponse;
import br.com.compras.modules.produto.actions.cadastro.service.core.CriaProdutoService;
import br.com.compras.modules.produto.actions.cadastro.service.mapper.CriaProdutoMapperService;
import br.com.compras.modules.produto.actions.cadastro.service.validator.CriaProdutoValidatorService;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.repository.dao.ProdutoDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriaProdutoServiceImpl implements CriaProdutoService {

    private final CriaProdutoValidatorService criaProdutoValidatorService;
    private final CriaProdutoMapperService criaProdutoMapperService;
    private final ProdutoDAO produtoDAO;

    @Override
    public CriaProdutoResponse realizaCriacaoDeUmNovoProduto(CriaProdutoRequest criaProdutoRequest) {

        log.debug("Metodo de servico responsavel por executar logica de criacao de novo produto acessado");
        log.trace("criaProdutoRequest: {}", criaProdutoRequest);

        log.debug("Iniciando acesso ao metodo responsavel por validar a unicidade do NOME recebido...");
        criaProdutoValidatorService.verificaSeNomeInformadoJaExiste(
                criaProdutoRequest.getNome()
        );
        log.debug("Acesso ao metodo responsavel por validar a unicidade do NOME recebido finalizado");

        log.debug("Iniciando acesso ao metodo de conversao de ProdutoEntity a partir de CriaProdutoRequest...");
        ProdutoEntity produtoGerado =
                criaProdutoMapperService.realizaCriacaoDeProdutoEntityAPartirDeCriaProdutoRequest(
                        criaProdutoRequest
                );
        log.debug("Acesso ao metodo de conversao de ProdutoEntity a partir de CriaProdutoRequest finalizado");
        log.trace("produtoGerado: {}", produtoGerado);

        log.debug("Iniciando acesso ao metodo responsavel por implementar a persistencia do produto no banco de dados...");
        ProdutoEntity produtoPersistido =
                produtoDAO.persisteEntidade(
                        produtoGerado
                );
        log.debug("Acesso ao metodo responsavel por implementar a persistencia do produto no banco de dados finalizado");
        log.trace("produtoPersistido: {}", produtoPersistido);

        log.debug("Iniciando acesso ao metodo de conversao de CriaProdutoResponse a partir de ProdutoEntity...");
        CriaProdutoResponse criaProdutoResponse =
                criaProdutoMapperService.realizaCriacaoDeCriaProdutoResponseAPartirDeProdutoEntity(
                        produtoPersistido
                );
        log.debug("Acesso ao metodo de conversao de CriaProdutoResponse a partir de ProdutoEntity finalizado");
        log.trace("criaProdutoResponse: {}", criaProdutoResponse);

        log.info("Criacao de novo produto realizada com sucesso");
        return criaProdutoResponse;
    }
}