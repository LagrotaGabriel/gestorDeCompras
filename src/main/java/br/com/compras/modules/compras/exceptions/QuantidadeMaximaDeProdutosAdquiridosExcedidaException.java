package br.com.compras.modules.compras.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuantidadeMaximaDeProdutosAdquiridosExcedidaException extends RuntimeException {
    public QuantidadeMaximaDeProdutosAdquiridosExcedidaException(String message) {
        super(message);
    }
}
