package br.com.compras.modules.produto.actions.cadastro.service.validator;

public interface CriaProdutoValidatorService {

    void verificaSeNomeInformadoJaExiste(
            String nome
    );
}
