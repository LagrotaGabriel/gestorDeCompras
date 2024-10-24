package br.com.compras.modules.cliente.actions.cadastro.dto.request.mock;

import br.com.compras.modules.cliente.actions.cadastro.dto.request.CriaClienteRequest;

public class CriaClienteRequestMock {

    private CriaClienteRequest criaClienteRequest;

    private CriaClienteRequestMock() {
    }

    public static CriaClienteRequestMock builder() {

        CriaClienteRequestMock builder = new CriaClienteRequestMock();

        CriaClienteRequest criaCliente = new CriaClienteRequest();
        criaCliente.setNome("Gabriel Lagrota");
        criaCliente.setCpf("222.222.222-22");

        builder.criaClienteRequest = criaCliente;

        return builder;
    }

    public CriaClienteRequest build() {
        return criaClienteRequest;
    }
}
