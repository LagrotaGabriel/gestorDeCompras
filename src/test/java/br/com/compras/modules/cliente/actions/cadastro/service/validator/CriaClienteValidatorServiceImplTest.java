package br.com.compras.modules.cliente.actions.cadastro.service.validator;

import br.com.compras.modules.cliente.actions.cadastro.exceptions.CpfDoClienteJaExisteException;
import br.com.compras.modules.cliente.actions.cadastro.service.validator.impl.CriaClienteValidatorServiceImpl;
import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.cliente.entity.mock.ClienteEntityMock;
import br.com.compras.modules.cliente.repository.dao.ClienteDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Validator: CriaCliente")
class CriaClienteValidatorServiceImplTest {

    @InjectMocks
    CriaClienteValidatorServiceImpl criaClienteValidatorServiceImpl;

    @Mock
    ClienteDAO clienteDAO;

    @Test
    @DisplayName("Realiza validação do método de verificação se CPF já existe com CPF inexistente")
    void realizaValidacaoDoMetodoDeVerificacaoSeCpfJaExisteComCpfInexistente() {

        when(clienteDAO.buscaPorCpf(any())).thenReturn(null);

        Assertions.assertDoesNotThrow(() ->
                criaClienteValidatorServiceImpl.verificaSeCpfInformadoJaExiste("111.111.111-11")
        );
    }

    @Test
    @DisplayName("Realiza validação do método de verificação se CPF já existe com CPF existente")
    void realizaValidacaoDoMetodoDeVerificacaoSeCpfJaExisteComCpfExistente() {

        ClienteEntity clienteMock = ClienteEntityMock.builder().build();

        when(clienteDAO.buscaPorCpf(any())).thenReturn(clienteMock);

        Assertions.assertThrows((CpfDoClienteJaExisteException.class), () ->
                criaClienteValidatorServiceImpl.verificaSeCpfInformadoJaExiste("111.111.111-11")
        );
    }
}
