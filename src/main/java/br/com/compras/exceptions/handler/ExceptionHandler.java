package br.com.compras.exceptions.handler;

import br.com.compras.exceptions.models.StandartError;
import br.com.compras.modules.cliente.actions.cadastro.exceptions.CpfDoClienteJaExisteException;
import br.com.compras.modules.compras.exceptions.ClienteNaoLocalizadoException;
import br.com.compras.modules.compras.exceptions.ProdutoAdquiridoNaoLocalizadoException;
import br.com.compras.modules.compras.exceptions.QuantidadeMaximaDeProdutosAdquiridosExcedidaException;
import br.com.compras.modules.produto.actions.cadastro.exceptions.NomeDoProdutoJaExisteException;
import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CpfDoClienteJaExisteException.class)
    public ResponseEntity<StandartError> cpfDoClienteJaExisteExceptionHandler(HttpServletRequest req,
                                                                              CpfDoClienteJaExisteException cpfDoClienteJaExisteException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(400)
                .error(cpfDoClienteJaExisteException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NomeDoProdutoJaExisteException.class)
    public ResponseEntity<StandartError> nomeDoProdutoJaExisteExceptionHandler(HttpServletRequest req,
                                                                               NomeDoProdutoJaExisteException nomeDoProdutoJaExisteException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(400)
                .error(nomeDoProdutoJaExisteException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(QuantidadeMaximaDeProdutosAdquiridosExcedidaException.class)
    public ResponseEntity<StandartError> quantidadeMaximaDeProdutosAdquiridosExcedidaExceptionHandler(HttpServletRequest req,
                                                                                                      QuantidadeMaximaDeProdutosAdquiridosExcedidaException quantidadeMaximaDeProdutosAdquiridosExcedidaException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(400)
                .error(quantidadeMaximaDeProdutosAdquiridosExcedidaException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ProdutoAdquiridoNaoLocalizadoException.class)
    public ResponseEntity<StandartError> produtoAdquiridoNaoLocalizadoExceptionHandler(HttpServletRequest req,
                                                                                       ProdutoAdquiridoNaoLocalizadoException produtoAdquiridoNaoLocalizadoException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(404)
                .error(produtoAdquiridoNaoLocalizadoException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ClienteNaoLocalizadoException.class)
    public ResponseEntity<StandartError> clienteNaoLocalizadoExceptionHandler(HttpServletRequest req,
                                                                              ClienteNaoLocalizadoException clienteNaoLocalizadoException) {

        StandartError standartError = StandartError.builder()
                .localDateTime(LocalDateTime.now().toString())
                .status(404)
                .error(clienteNaoLocalizadoException.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
    }

    @Nonnull

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
