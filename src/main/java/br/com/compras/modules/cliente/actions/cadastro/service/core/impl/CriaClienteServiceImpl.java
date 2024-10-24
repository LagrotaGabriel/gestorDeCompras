package br.com.compras.modules.cliente.actions.cadastro.service.core.impl;

import br.com.compras.modules.cliente.actions.cadastro.dto.request.CriaClienteRequest;
import br.com.compras.modules.cliente.actions.cadastro.dto.response.CriaClienteResponse;
import br.com.compras.modules.cliente.actions.cadastro.service.core.CriaClienteService;
import br.com.compras.modules.cliente.actions.cadastro.service.mapper.CriaClienteMapperService;
import br.com.compras.modules.cliente.actions.cadastro.service.validator.CriaClienteValidatorService;
import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.cliente.repository.dao.ClienteDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriaClienteServiceImpl implements CriaClienteService {

    private final CriaClienteValidatorService criaClienteValidatorService;
    private final CriaClienteMapperService criaClienteMapperService;
    private final ClienteDAO clienteDAO;

    @Override
    public CriaClienteResponse realizaCadastroDoCliente(CriaClienteRequest criaClienteRequest) {

        log.debug("Metodo de servico responsavel por executar logica de criacao de novo cliente acessado");
        log.trace("criaClienteRequest: {}", criaClienteRequest);

        log.debug("Iniciando acesso ao metodo responsavel por validar a unicidade do CPF recebido...");
        criaClienteValidatorService.verificaSeCpfInformadoJaExiste(
                criaClienteRequest.getCpf()
        );
        log.debug("Acesso ao metodo responsavel por validar a unicidade do CPF recebido finalizado");

        log.debug("Iniciando acesso ao metodo de conversao de ClienteEntity a partir de CriaClienteRequest...");
        ClienteEntity clienteGerado =
                criaClienteMapperService.realizaCriacaoDeClienteEntityAPartirDeCriaClienteRequest(
                        criaClienteRequest
                );
        log.debug("Acesso ao metodo de conversao de ClienteEntity a partir de CriaClienteRequest finalizado");
        log.trace("clienteGerado: {}", clienteGerado);

        log.debug("Iniciando acesso ao metodo responsavel por implementar a persistencia do Cliente no banco de dados...");
        ClienteEntity clientePersistido =
                clienteDAO.persisteEntidade(
                        clienteGerado
                );
        log.debug("Acesso ao metodo responsavel por implementar a persistencia do cliente no banco de dados finalizado");
        log.trace("clientePersistido: {}", clientePersistido);

        log.debug("Iniciando acesso ao metodo de conversao de CriaClienteResponse a partir de ClienteEntity...");
        CriaClienteResponse criaClienteResponse =
                criaClienteMapperService.realizaCriacaoDeCriaClienteResponseAPartirDeClienteEntity(
                        clientePersistido
                );
        log.debug("Acesso ao metodo de conversao de CriaClienteResponse a partir de ClienteEntity finalizado");
        log.trace("criaClienteResponse: {}", criaClienteResponse);

        log.info("Criacao de novo cliente realizada com sucesso");
        return criaClienteResponse;
    }
}
