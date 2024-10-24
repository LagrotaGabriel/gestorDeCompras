package br.com.compras.modules.cliente.actions.cadastro.dto.response.mock;

import br.com.compras.modules.cliente.actions.cadastro.dto.response.CriaClienteResponse;

import java.util.UUID;

public class CriaClienteResponseMock {

    private CriaClienteResponse criaClienteResponse;

    private CriaClienteResponseMock() {
    }

    public static CriaClienteResponseMock builder() {

        CriaClienteResponseMock builder = new CriaClienteResponseMock();

        CriaClienteResponse criaCliente = new CriaClienteResponse();
        criaCliente.setId(UUID.fromString("74bcd515-655c-4def-8dc8-3329ccbdf62e"));

        builder.criaClienteResponse = criaCliente;

        return builder;
    }

    public CriaClienteResponse build() {
        return criaClienteResponse;
    }
}
