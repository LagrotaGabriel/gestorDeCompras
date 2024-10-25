package br.com.compras.modules.compras.actions.cadastro.services.validator;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.cliente.entity.mock.ClienteEntityMock;
import br.com.compras.modules.compras.actions.cadastro.dto.request.CriaCompraRequest;
import br.com.compras.modules.compras.actions.cadastro.dto.request.mock.CriaCompraRequestMock;
import br.com.compras.modules.compras.actions.cadastro.services.validator.impl.CriaCompraValidatorServiceImpl;
import br.com.compras.modules.compras.entity.CompraEntity;
import br.com.compras.modules.compras.entity.mock.CompraEntityMock;
import br.com.compras.modules.compras.exceptions.ClienteNaoLocalizadoException;
import br.com.compras.modules.compras.exceptions.ProdutoAdquiridoNaoLocalizadoException;
import br.com.compras.modules.compras.exceptions.QuantidadeMaximaDeProdutosAdquiridosExcedidaException;
import br.com.compras.modules.compras.repository.dao.CompraDAO;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import br.com.compras.modules.produto.entity.mock.ProdutoEntityMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("ValidatorService: CriaCompra")
class CriaCompraValidatorServiceImplTest {

    @InjectMocks
    CriaCompraValidatorServiceImpl criaCompraValidatorServiceImpl;

    @Mock
    CompraDAO compraDAO;

    @Test
    @DisplayName("Deve testar validacoes de negocio do cadastro da compra")
    void deveTestarValidacoesDeNegocioDoCadastroDaCompra() {

        CriaCompraRequest criaCompraRequestMock = CriaCompraRequestMock.builder().build();

        CompraEntity compraEntityMock =
                CompraEntityMock.builder()
                        .comCliente()
                        .comProduto()
                        .build();

        CriaCompraValidatorServiceImpl criaCompraValidatorServiceSpy = Mockito.spy(criaCompraValidatorServiceImpl);

        doNothing().when(criaCompraValidatorServiceSpy).validaSeAlgumClienteFoiEncontradoAtravesDoCpfInformado(any(), any());
        doNothing().when(criaCompraValidatorServiceSpy).validaSeAlgumProdutoFoiEncontradoAtravesDoNomeInformado(any());
        doNothing().when(criaCompraValidatorServiceSpy).validaSeClienteIraExcederLimiteDeComprasDoProduto(any(), any(), any());

        Assertions.assertDoesNotThrow(() ->
                criaCompraValidatorServiceImpl.realizaValidacoesDeNegocioDoCadastroDaCompra(
                        criaCompraRequestMock,
                        compraEntityMock
                )
        );
    }

    @Test
    @DisplayName("Deve testar validacao se algum cliente foi encontrado pelo CPF informado com sucesso")
    void deveTestarValidacaoSeAlgumClienteFoiEncontradoPeloCpfInformadoComSucesso() {

        ClienteEntity clienteMock = ClienteEntityMock.builder().build();

        Assertions.assertDoesNotThrow(() ->
                criaCompraValidatorServiceImpl.validaSeAlgumClienteFoiEncontradoAtravesDoCpfInformado(
                        "111.111.111-11",
                        clienteMock
                )
        );
    }

    @Test
    @DisplayName("Deve testar validacao se algum cliente foi encontrado pelo CPF informado com erro")
    void deveTestarValidacaoSeAlgumClienteFoiEncontradoPeloCpfInformadoComErro() {

        Assertions.assertThrows((ClienteNaoLocalizadoException.class), () ->
                criaCompraValidatorServiceImpl.validaSeAlgumClienteFoiEncontradoAtravesDoCpfInformado(
                        "111.111.111-11",
                        null
                )
        );
    }

    @Test
    @DisplayName("Deve testar validacao se algum cliente foi encontrado pelo CPF informado com Cpf vazio")
    void deveTestarValidacaoSeAlgumClienteFoiEncontradoPeloCpfInformadoComCpfVazio() {

        Assertions.assertDoesNotThrow(() ->
                criaCompraValidatorServiceImpl.validaSeAlgumClienteFoiEncontradoAtravesDoCpfInformado(
                        "",
                        null
                )
        );
    }

    @Test
    @DisplayName("Deve testar validação se nenhum produto foi encontrado pelo nome informado com sucesso")
    void deveTestarValidacaoSeNenhumProdutoFoiEncontradoPeloNomeInformadoComSucesso() {

        ProdutoEntity produtoMock = ProdutoEntityMock.builder().build();

        Assertions.assertDoesNotThrow(() ->
                criaCompraValidatorServiceImpl.validaSeAlgumProdutoFoiEncontradoAtravesDoNomeInformado(
                        produtoMock
                )
        );
    }

    @Test
    @DisplayName("Deve testar validação se nenhum produto foi encontrado pelo nome informado com erro")
    void deveTestarValidacaoSeNenhumProdutoFoiEncontradoPeloNomeInformadoComErro() {

        Assertions.assertThrows((ProdutoAdquiridoNaoLocalizadoException.class), () ->
                criaCompraValidatorServiceImpl.validaSeAlgumProdutoFoiEncontradoAtravesDoNomeInformado(
                        null
                )
        );
    }

    @Test
    @DisplayName("Deve testar validação se cliente irá exceder limite de compras do produto com sucesso")
    void deveTestarValidacaoSeClienteIraExcederLimiteDeComprasDoProdutoComSucesso() {

        ProdutoEntity produtoMock = ProdutoEntityMock.builder().build();
        ClienteEntity clienteMock = ClienteEntityMock.builder().build();

        when(compraDAO.realizaContagemDaQuantidadeDeProdutosPorIdAdquiridosPeloCliente(any(), any())).thenReturn(1);

        Assertions.assertDoesNotThrow(() ->
                criaCompraValidatorServiceImpl.validaSeClienteIraExcederLimiteDeComprasDoProduto(
                        1,
                        produtoMock,
                        clienteMock
                )
        );
    }

    @Test
    @DisplayName("Deve testar validação se cliente irá exceder limite de compras do produto com Erro")
    void deveTestarValidacaoSeClienteIraExcederLimiteDeComprasDoProdutoComErro() {

        ProdutoEntity produtoMock = ProdutoEntityMock.builder().build();
        ClienteEntity clienteMock = ClienteEntityMock.builder().build();

        when(compraDAO.realizaContagemDaQuantidadeDeProdutosPorIdAdquiridosPeloCliente(any(), any())).thenReturn(3);

        Assertions.assertThrows((QuantidadeMaximaDeProdutosAdquiridosExcedidaException.class), () ->
                criaCompraValidatorServiceImpl.validaSeClienteIraExcederLimiteDeComprasDoProduto(
                        1,
                        produtoMock,
                        clienteMock
                )
        );
    }

    @Test
    @DisplayName("Deve testar validação se cliente irá exceder limite de compras do produto com cliente nulo")
    void deveTestarValidacaoSeClienteIraExcederLimiteDeComprasDoProdutoComClienteNulo() {

        ProdutoEntity produtoMock = ProdutoEntityMock.builder().build();

        Assertions.assertDoesNotThrow(() ->
                criaCompraValidatorServiceImpl.validaSeClienteIraExcederLimiteDeComprasDoProduto(
                        1,
                        produtoMock,
                        null
                )
        );
    }
}
