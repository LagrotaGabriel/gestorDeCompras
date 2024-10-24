package br.com.compras.modules.cliente.actions.cadastro.service.validator.impl;

import br.com.compras.modules.cliente.actions.cadastro.exceptions.CpfDoClienteJaExisteException;
import br.com.compras.modules.cliente.actions.cadastro.service.validator.CriaClienteValidatorService;
import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.cliente.repository.dao.ClienteDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriaClienteValidatorServiceImpl implements CriaClienteValidatorService {

    private final ClienteDAO clienteDAO;

    @Override
    public void verificaSeCpfInformadoJaExiste(String cpf) {

        log.debug("Metodo de validacao responsavel por verificar se CPF informado ja existe acessado");
        log.trace("cpf: {}", cpf);

        log.debug("Iniciando acesso ao metodo responsavel por realizar a busca de cliente por cpf no banco de dados...");
        ClienteEntity clienteEncontrado = clienteDAO.buscaPorCpf(cpf);
        log.debug("Acesso ao metodo responsavel por realizar a busca de cliente por cpf no banco de dados finalizado");
        log.trace("clienteEncontrado: {}", clienteEncontrado);

        if (clienteEncontrado != null) {
            log.warn("O CPF informado para o cadastro do cliente já existe");
            throw new CpfDoClienteJaExisteException("O CPF informado já existe. Insira outro CPF e tente novamente.");
        }

        log.debug("Validacao finalizada com sucesso");
    }
}
