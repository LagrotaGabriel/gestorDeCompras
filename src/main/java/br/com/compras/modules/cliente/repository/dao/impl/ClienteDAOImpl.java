package br.com.compras.modules.cliente.repository.dao.impl;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.cliente.repository.ClienteRepository;
import br.com.compras.modules.cliente.repository.dao.ClienteDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteDAOImpl implements ClienteDAO {

    private final ClienteRepository clienteRepository;

    @Override
    @Transactional
    public ClienteEntity persisteEntidade(ClienteEntity clienteEntity) {

        log.debug("Metodo responsavel por realizar a persistencia do cliente no banco de dados acessado");
        log.trace("clienteEntity: {}", clienteEntity);

        log.debug("Realizando persistencia do cliente no banco de dados...");
        ClienteEntity clientePersistido = clienteRepository.save(clienteEntity);
        log.debug("Cliente persistido com sucesso");
        log.trace("clientePersistido: {}", clientePersistido);

        log.debug("Retornando cliente persistido...");
        return clientePersistido;
    }

    @Override
    public ClienteEntity buscaPorCpf(String cpf) {

        log.debug("Metodo responsavel por realizar a busca de um cliente por CPF no banco de dados acessado");
        log.trace("cpf: {}", cpf);

        log.debug("Realizando busca do cliente por CPF no banco de dados...");
        Optional<ClienteEntity> clienteOptional = clienteRepository.findByCpf(cpf);
        log.debug("Busca realizada com sucesso");
        log.trace("clienteOptional: {}", clienteOptional);

        log.debug("Retornando resultado da busca...");
        return clienteOptional.orElse(null);
    }
}
