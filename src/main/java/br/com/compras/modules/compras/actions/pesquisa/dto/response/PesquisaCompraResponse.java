package br.com.compras.modules.compras.actions.pesquisa.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PesquisaCompraResponse {

    private UUID id;
    private LocalDateTime dataHoraCadastro;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private String nomeProduto;
    private String nomeCliente;
    private String cpfCliente;
}
