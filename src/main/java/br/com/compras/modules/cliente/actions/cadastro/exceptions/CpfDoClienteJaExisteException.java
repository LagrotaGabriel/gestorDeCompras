package br.com.compras.modules.cliente.actions.cadastro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfDoClienteJaExisteException extends RuntimeException {
    public CpfDoClienteJaExisteException(String message) {
        super(message);
    }
}
