package br.com.compras.modules.cliente.actions.cadastro.service.mapper;

import br.com.compras.modules.cliente.actions.cadastro.dto.request.CriaClienteRequest;
import br.com.compras.modules.cliente.actions.cadastro.dto.request.mock.CriaClienteRequestMock;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.CriaClienteResponse;
import br.com.compras.modules.cliente.actions.cadastro.service.mapper.impl.CriaClienteMapperServiceImpl;
import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.cliente.entity.mock.ClienteEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Mapper: CriaCliente")
class CriaClienteMapperServiceImplTest {

    @InjectMocks
    CriaClienteMapperServiceImpl mapperServiceImpl;

    @Test
    @DisplayName("Deve testar conversao de ClienteEntity a partir de CriaClienteRequest")
    void deveTestarConversaoDeClienteEntityAPartirDeCriaClienteRequest() {

        CriaClienteRequest criaClienteRequestMock = CriaClienteRequestMock.builder().build();

        ClienteEntity clienteEntityGerado =
                mapperServiceImpl.realizaCriacaoDeClienteEntityAPartirDeCriaClienteRequest(
                        criaClienteRequestMock
                );

        Assertions.assertNotNull(
                clienteEntityGerado.toString()
        );
    }

    @Test
    @DisplayName("Deve testar conversao de CriaClienteResponse a partir de ClienteEntity")
    void deveTestarConversaoDeClienteResponseAPartirDeClienteEntity() {

        ClienteEntity clienteEntityMock = ClienteEntityMock.builder().build();

        CriaClienteResponse clienteResponseGerado =
                mapperServiceImpl.realizaCriacaoDeCriaClienteResponseAPartirDeClienteEntity(
                        clienteEntityMock
                );

        Assertions.assertNotNull(
                clienteResponseGerado.toString()
        );
    }
}
