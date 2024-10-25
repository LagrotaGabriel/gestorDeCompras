package br.com.compras.modules.compras.repository.dao.impl;

import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.compras.repository.CompraRepository;
import br.com.compras.modules.compras.repository.dao.CompraDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompraDAOImpl implements CompraDAO {

    private final CompraRepository compraRepository;

    @Override
    @Transactional
    public CompraEntity persisteEntidade(CompraEntity compraEntity) {

        log.debug("Metodo responsavel por implementar persistencia da compra no banco de dados acessado");
        log.trace("compraEntity: {}", compraEntity);

        log.debug("Realizando persistencia da compra no banco de dados...");
        CompraEntity compraPersistido = compraRepository.save(compraEntity);
        log.debug("Compra persistida com sucesso");
        log.trace("compraPersistido: {}", compraPersistido);

        log.debug("Retornando compra persistida...");
        return compraPersistido;
    }

    @Override
    public Integer realizaContagemDaQuantidadeDeProdutosPorIdAdquiridosPeloCliente(UUID idProdutoAdquirido,
                                                                                   UUID idClienteComprador) {

        log.debug("Metodo responsavel por implementar contagem da quantidade de produtos por id adquiridos pelo cliente no banco de dados acessado");
        log.trace("idProdutoAdquirido: {}", idProdutoAdquirido);
        log.trace("idClienteComprador: {}", idClienteComprador);

        log.debug("Realizando consulta no banco de dados...");
        Integer quantidadeDeProdutosAdquiridos =
                compraRepository.realizaContagemDeQuantosProdutosForamAdquiridosPeloCliente(
                        idProdutoAdquirido,
                        idClienteComprador
                );
        log.debug("Consulta no banco de dados realizada com sucesso");
        log.trace("quantidadeDeProdutosAdquiridos: {}", quantidadeDeProdutosAdquiridos);

        log.debug("Retornando contagem obtida...");
        return quantidadeDeProdutosAdquiridos;
    }

    @Override
    public List<CompraEntity> realizaPesquisa(String buscaPorCpfCliente,
                                              String buscaPorNomeProduto,
                                              LocalDateTime dataInicio,
                                              LocalDateTime dataFim) {

        log.debug("Metodo responsavel por implementar pesquisa de compras no banco de dados acessado");
        log.trace("buscaPorCpfCliente: {}", buscaPorCpfCliente);
        log.trace("buscaPorNomeProduto: {}", buscaPorNomeProduto);
        log.trace("dataInicio: {}", dataInicio);
        log.trace("dataFim: {}", dataFim);

        log.debug("Realizando pesquisa no banco de dados...");
        List<CompraEntity> comprasEncontradas =
                compraRepository.pesquisaCompras(
                        buscaPorCpfCliente,
                        buscaPorNomeProduto,
                        dataInicio,
                        dataFim
                );
        log.debug("Pesquisa no banco de dados realizada com sucesso");
        log.trace("comprasEncontradas: {}", comprasEncontradas);

        log.debug("Retornando compras obtidas...");
        return comprasEncontradas;
    }
}
