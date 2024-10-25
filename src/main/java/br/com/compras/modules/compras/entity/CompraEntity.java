package br.com.compras.modules.compras.entity;

import br.com.compras.modules.cliente.entity.ClienteEntity;
import br.com.compras.modules.produto.entity.ProdutoEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_COMPRA")
public class CompraEntity {

    @Id
    @Comment("Chave primária da compra - UUID")
    @Column(name = "COD_COMPRA_CMP", nullable = false, updatable = false)
    private UUID id;

    @Comment("Data e hora que a compra foi cadastrada")
    @Column(name = "LDT_DATAHORACADASTRO_CMP", nullable = false, updatable = false)
    private LocalDateTime dataHoraCadastro;

    @Comment("Quantidade de produtos adquiridos")
    @Column(name = "INT_QUANTIDADE_MINIMA_PDT", nullable = false)
    private Integer quantidade;

    @Comment("Valor unitário da compra realizada")
    @Column(name = "DCM_VALORUNITARIO_PDT", scale = 2, nullable = false)
    private BigDecimal valorUnitario;

    @ToString.Exclude
    @Comment("Produto da compra")
    @ManyToOne(targetEntity = ProdutoEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_PRODUTO_CMP", referencedColumnName = "COD_PRODUTO_PDT", nullable = false, updatable = false)
    private ProdutoEntity produto;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("Cliente que realizou a compra")
    @JoinColumn(name = "COD_CLIENTE_CMP", referencedColumnName = "COD_CLIENTE_CLN", nullable = false, updatable = false)
    private ClienteEntity cliente;
}
