package br.com.compras.modules.produto.repository.dao;

import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.entity.mock.ProdutoEntityMock;
import br.com.compras.modules.produto.repository.ProdutoRepository;
import br.com.compras.modules.produto.repository.dao.impl.ProdutoDAOImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("DAO: Produto")
class ProdutoDAOImplTest {

    @InjectMocks
    ProdutoDAOImpl produtoDAOImpl;

    @Mock
    ProdutoRepository produtoRepository;

    @Test
    @DisplayName("Deve testar implementação de persistência de produto")
    void deveTestarImplementacaoDePersistenciaDeProduto() {

        ProdutoEntity produtoEntityMock = ProdutoEntityMock.builder().build();

        when(produtoRepository.save(any())).thenReturn(produtoEntityMock);

        ProdutoEntity produtoEntityPersistido = produtoDAOImpl.persisteEntidade(produtoEntityMock);

        Assertions.assertEquals(
                "ProdutoEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Batedeira)",
                produtoEntityPersistido.toString()
        );
    }
}
