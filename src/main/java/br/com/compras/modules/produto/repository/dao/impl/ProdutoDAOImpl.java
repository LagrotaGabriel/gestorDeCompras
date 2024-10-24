package br.com.compras.modules.produto.repository.dao.impl;

import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.repository.ProdutoRepository;
import br.com.compras.modules.produto.repository.dao.ProdutoDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoDAOImpl implements ProdutoDAO {

    private final ProdutoRepository produtoRepository;

    @Override
    @Transactional
    public ProdutoEntity persisteEntidade(ProdutoEntity produtoEntity) {

        log.debug("Metodo de responsavel por implementar persistencia do produto no banco de dados acessado");
        log.trace("produtoEntity: {}", produtoEntity);

        log.debug("Realizando persistencia do produto no banco de dados...");
        ProdutoEntity produtoPersistido = produtoRepository.save(produtoEntity);
        log.debug("Produto persistido com sucesso");
        log.trace("produtoPersistido: {}", produtoPersistido);

        log.debug("Retornando produto persistido...");
        return produtoPersistido;
    }

    @Override
    public ProdutoEntity buscaPorNome(String nome) {

        log.debug("Metodo responsavel por realizar a busca de um produto por nome no banco de dados acessado");
        log.trace("nome: {}", nome);

        log.debug("Realizando busca do produto por nome no banco de dados...");
        Optional<ProdutoEntity> produtoOptional = produtoRepository.findByNomeIgnoreCase(nome);
        log.debug("Busca realizada com sucesso");
        log.trace("produtoOptional: {}", produtoOptional);

        log.debug("Retornando resultado da busca...");
        return produtoOptional.orElse(null);
    }
}
