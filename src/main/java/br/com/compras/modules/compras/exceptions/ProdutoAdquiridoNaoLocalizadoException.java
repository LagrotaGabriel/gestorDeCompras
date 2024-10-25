package br.com.compras.modules.compras.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProdutoAdquiridoNaoLocalizadoException extends RuntimeException {
    public ProdutoAdquiridoNaoLocalizadoException(String message) {
        super(message);
    }
}
