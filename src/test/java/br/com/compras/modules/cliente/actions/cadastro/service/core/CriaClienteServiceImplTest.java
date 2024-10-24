package br.com.compras.modules.cliente.actions.cadastro.service.core;

import br.com.compras.modules.cliente.actions.cadastro.dto.request.CriaClienteRequest;
import br.com.compras.modules.cliente.actions.cadastro.dto.request.mock.CriaClienteRequestMock;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.CriaClienteResponse;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.mock.CriaClienteResponseMock;
import br.com.compras.modules.cliente.actions.cadastro.service.core.impl.CriaClienteServiceImpl;
import br.com.compras.modules.cliente.actions.cadastro.service.mapper.CriaClienteMapperService;
import br.com.compras.modules.cliente.actions.cadastro.service.validator.CriaClienteValidatorService;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Service: CriaCliente")
class CriaClienteServiceImplTest {

    @InjectMocks
    CriaClienteServiceImpl criaClienteService;

    @Mock
    CriaClienteValidatorService validatorService;

    @Mock
    CriaClienteMapperService mapperService;

    @Mock
    ClienteDAO clienteDAO;

    @Test
    @DisplayName("Deve testar criacao de novo cliente")
    void deveTestarCriacaoDeNovoCliente() {

        CriaClienteRequest criaClienteRequestMock = CriaClienteRequestMock.builder().build();
        ClienteEntity clienteEntityMock = ClienteEntityMock.builder().build();
        CriaClienteResponse criaClienteResponseMock = CriaClienteResponseMock.builder().build();

        doNothing().when(validatorService).verificaSeCpfInformadoJaExiste(any());
        when(mapperService.realizaCriacaoDeClienteEntityAPartirDeCriaClienteRequest(any())).thenReturn(clienteEntityMock);
        when(clienteDAO.persisteEntidade(any())).thenReturn(clienteEntityMock);
        when(mapperService.realizaCriacaoDeCriaClienteResponseAPartirDeClienteEntity(any())).thenReturn(criaClienteResponseMock);

        CriaClienteResponse criaClienteResponseRetornado =
                criaClienteService.realizaCadastroDoCliente(
                        criaClienteRequestMock
                );

        Assertions.assertEquals(
                criaClienteResponseMock,
                criaClienteResponseRetornado
        );
    }
}
