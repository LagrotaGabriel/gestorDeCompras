package br.com.compras.modules.cliente.repository.dao;

import br.com.compras.modules.cliente.entity.ClienteEntity;

public interface ClienteDAO {

    ClienteEntity persisteEntidade(
            ClienteEntity clienteEntity
    );

    ClienteEntity buscaPorCpf(
            String cpf
    );
}
