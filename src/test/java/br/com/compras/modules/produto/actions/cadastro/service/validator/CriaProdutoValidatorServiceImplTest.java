package br.com.compras.modules.produto.actions.cadastro.service.validator;

import br.com.compras.modules.produto.actions.cadastro.exceptions.NomeDoProdutoJaExisteException;
import br.com.compras.modules.produto.actions.cadastro.service.validator.impl.CriaProdutoValidatorServiceImpl;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.entity.mock.ProdutoEntityMock;
import br.com.compras.modules.produto.repository.dao.ProdutoDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Validator: CriaProduto")
class CriaProdutoValidatorServiceImplTest {

    @InjectMocks
    CriaProdutoValidatorServiceImpl criaProdutoValidatorServiceImpl;

    @Mock
    ProdutoDAO produtoDAO;

    @Test
    @DisplayName("Realiza validação do método de verificação se CPF já existe com CPF inexistente")
    void realizaValidacaoDoMetodoDeVerificacaoSeCpfJaExisteComCpfInexistente() {

        when(produtoDAO.buscaPorNome(any())).thenReturn(null);

        Assertions.assertDoesNotThrow(() ->
                criaProdutoValidatorServiceImpl.verificaSeNomeInformadoJaExiste("111.111.111-11")
        );
    }

    @Test
    @DisplayName("Realiza validação do método de verificação se CPF já existe com CPF existente")
    void realizaValidacaoDoMetodoDeVerificacaoSeCpfJaExisteComCpfExistente() {

        ProdutoEntity produtoMock = ProdutoEntityMock.builder().build();

        when(produtoDAO.buscaPorNome(any())).thenReturn(produtoMock);

        Assertions.assertThrows((NomeDoProdutoJaExisteException.class), () ->
                criaProdutoValidatorServiceImpl.verificaSeNomeInformadoJaExiste("111.111.111-11")
        );
    }
}
