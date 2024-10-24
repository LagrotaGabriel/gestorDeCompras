package br.com.compras.modules.cliente.repository.dao.impl;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.cliente.entity.mock.ClienteEntityMock;
import br.com.compras.modules.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("DAO: Cliente")
class ClienteDAOImplTest {

    @InjectMocks
    ClienteDAOImpl clienteDAOImpl;

    @Mock
    ClienteRepository clienteRepository;

    @Test
    @DisplayName("Deve testar implementação de persistência de cliente")
    void deveTestarImplementacaoDePersistenciaDeCliente() {

        ClienteEntity clienteEntityMock = ClienteEntityMock.builder().build();

        when(clienteRepository.save(any())).thenReturn(clienteEntityMock);

        ClienteEntity clienteEntityPersistido = clienteDAOImpl.persisteEntidade(clienteEntityMock);

        Assertions.assertEquals(
                "ClienteEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Gabriel Lagrota, cpf=123.189.265-38)",
                clienteEntityPersistido.toString()
        );
    }

    @Test
    @DisplayName("Deve testar implementação de busca de cliente por CPF")
    void deveTestarImplementacaoDeBuscaDeClientePorCpf() {

        ClienteEntity clienteEntityMock = ClienteEntityMock.builder().build();

        when(clienteRepository.findByCpf(any())).thenReturn(Optional.of(clienteEntityMock));

        ClienteEntity clienteEncontrado = clienteDAOImpl.buscaPorCpf("555.555.555-55");

        Assertions.assertEquals(
                "ClienteEntity(id=74bcd515-655c-4def-8dc8-3329ccbdf62e, nome=Gabriel Lagrota, cpf=123.189.265-38)",
                clienteEncontrado.toString()
        );
    }
}
