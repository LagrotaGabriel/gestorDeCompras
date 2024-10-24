package br.com.compras.modules.cliente.entity.mock;

import br.com.compras.modules.cliente.entity.ClienteEntity;

import java.util.UUID;

public class ClienteEntityMock {

    private ClienteEntity clienteEntity;

    private ClienteEntityMock() {
    }

    public static ClienteEntityMock builder() {

        ClienteEntityMock builder = new ClienteEntityMock();

        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"));
        cliente.setNome("Gabriel Lagrota");
        cliente.setCpf("123.189.265-38");

        builder.clienteEntity = cliente;

        return builder;
    }

    public ClienteEntity build() {
        return clienteEntity;
    }
}
