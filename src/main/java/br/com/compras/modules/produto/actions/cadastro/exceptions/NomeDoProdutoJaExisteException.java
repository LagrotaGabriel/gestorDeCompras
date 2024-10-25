package br.com.compras.modules.produto.actions.cadastro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeDoProdutoJaExisteException extends RuntimeException {
    public NomeDoProdutoJaExisteException(String message) {
        super(message);
    }
}
