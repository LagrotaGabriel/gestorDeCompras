package br.com.compras.modules.cliente.actions.cadastro.service.mapper.impl;

import br.com.compras.modules.cliente.actions.cadastro.dto.request.CriaClienteRequest;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.CriaClienteResponse;
import br.com.compras.modules.cliente.actions.cadastro.service.mapper.CriaClienteMapperService;
import br.com.compras.modules.cliente.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriaClienteMapperServiceImpl implements CriaClienteMapperService {

    @Override
    public ClienteEntity realizaCriacaoDeClienteEntityAPartirDeCriaClienteRequest(CriaClienteRequest criaClienteRequest) {

        log.debug("Mapper responsavel por converter CriaClienteRequest em ClienteEntity acessado");
        log.trace("criaClienteRequest: {}", criaClienteRequest);

        log.debug("Iniciando criacao de objeto do tipo ClienteEntity...");
        ClienteEntity clienteEntity =
                ClienteEntity.builder()
                        .id(UUID.randomUUID())
                        .nome(criaClienteRequest.getNome())
                        .cpf(criaClienteRequest.getCpf())
                        .build();
        log.debug("Criacao de objeto do tipo ClienteEntity realizada com sucesso");
        log.trace("clienteEntity: {}", clienteEntity);

        log.debug("Retornando objeto clienteEntity criado...");
        return clienteEntity;
    }

    @Override
    public CriaClienteResponse realizaCriacaoDeCriaClienteResponseAPartirDeClienteEntity(ClienteEntity clienteEntity) {

        log.debug("Mapper responsavel por converter ClienteEntity em CriaClienteResponse acessado");
        log.trace("criaClienteResponse: {}", clienteEntity);

        log.debug("Iniciando criacao de objeto do tipo CriaClienteResponse...");
        CriaClienteResponse criaClienteResponse =
                CriaClienteResponse.builder()
                        .id(clienteEntity.getId())
                        .build();
        log.debug("Criacao de objeto do tipo criaClienteResponse realizada com sucesso");
        log.trace("criaClienteResponse: {}", criaClienteResponse);

        log.debug("Retornando objeto criaClienteResponse criado...");
        return criaClienteResponse;
    }
}
