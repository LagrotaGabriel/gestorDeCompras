package br.com.compras.modules.produto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PRODUTO")
public class ProdutoEntity {

    @Id
    @Comment("Chave primária do produto - UUID")
    @Column(name = "COD_PRODUTO_PDT", nullable = false, updatable = false)
    private UUID id;

    @Comment("Nome do produto")
    @Column(name = "STR_NOME_PDT", nullable = false, updatable = false, length = 60)
    private String nome;
}
