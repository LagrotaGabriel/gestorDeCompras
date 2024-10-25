package br.com.compras.modules.produto.actions.cadastro.service.validator.impl;

import br.com.compras.modules.produto.actions.cadastro.exceptions.NomeDoProdutoJaExisteException;
import br.com.compras.modules.produto.actions.cadastro.service.validator.CriaProdutoValidatorService;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.repository.dao.ProdutoDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriaProdutoValidatorServiceImpl implements CriaProdutoValidatorService {

    private final ProdutoDAO produtoDAO;

    @Override
    public void verificaSeNomeInformadoJaExiste(String nome) {

        log.debug("Metodo de validacao responsavel por verificar se nome de produto informado ja existe acessado");
        log.trace("nome: {}", nome);

        log.debug("Iniciando acesso ao metodo responsavel por realizar a busca de produto por nome no banco de dados...");
        ProdutoEntity produtoEncontrado = produtoDAO.buscaPorNome(nome);
        log.debug("Acesso ao metodo responsavel por realizar a busca de produto por nome no banco de dados finalizado");
        log.trace("produtoEncontrado: {}", produtoEncontrado);

        if (produtoEncontrado != null) {
            log.warn("O NOME informado para o cadastro do produto já existe");
            throw new NomeDoProdutoJaExisteException("O NOME informado já existe. Insira outro NOME e tente novamente.");
        }

        log.debug("Validacao finalizada com sucesso");
    }
}
