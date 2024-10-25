package br.com.compras.modules.compras.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoLocalizadoException extends RuntimeException {
    public ClienteNaoLocalizadoException(String message) {
        super(message);
    }
}
