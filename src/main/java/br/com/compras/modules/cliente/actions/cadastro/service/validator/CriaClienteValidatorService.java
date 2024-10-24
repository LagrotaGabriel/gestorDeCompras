package br.com.compras.modules.cliente.actions.cadastro.service.validator;

public interface CriaClienteValidatorService {

    void verificaSeCpfInformadoJaExiste(
            String cpf
    );
}
