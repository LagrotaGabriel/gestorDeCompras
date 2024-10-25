package br.com.compras.modules.compras.entity.mock;

import br.com.compras.modules.cliente.entity.mock.ClienteEntityMock;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.produto.entity.mock.ProdutoEntityMock;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompraEntityMock {

    private CompraEntity compraEntity;

    private CompraEntityMock() {
    }

    public static CompraEntityMock builder() {

        CompraEntityMock builder = new CompraEntityMock();

        CompraEntity compra = new CompraEntity();
        compra.setId(UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"));
        compra.setDataHoraCadastro(LocalDateTime.of(2024, 10, 24, 16, 35, 0));
        compra.setQuantidade(1);
        compra.setValorUnitario(BigDecimal.valueOf(100.0));
        compra.setProduto(null);
        compra.setCliente(null);

        builder.compraEntity = compra;

        return builder;
    }

    public CompraEntityMock comCliente() {
        this.compraEntity.setCliente(ClienteEntityMock.builder().build());
        return this;
    }

    public CompraEntityMock comProduto() {
        this.compraEntity.setProduto(ProdutoEntityMock.builder().build());
        return this;
    }

    public CompraEntity build() {
        return compraEntity;
    }

    public List<CompraEntity> buildList() {

        List<CompraEntity> compraEntityList = new ArrayList<>();
        compraEntityList.add(compraEntity);

        return compraEntityList;
    }
}
