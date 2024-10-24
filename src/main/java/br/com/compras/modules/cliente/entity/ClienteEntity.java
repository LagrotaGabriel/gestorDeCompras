package br.com.compras.modules.cliente.entity;

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
@Table(name = "TB_CLIENTE")
public class ClienteEntity {

    @Id
    @Comment("Chave primária do cliente - UUID")
    @Column(name = "COD_CLIENTE_CLN", nullable = false, updatable = false)
    private UUID id;

    @Comment("Nome do cliente")
    @Column(name = "STR_NOME_CLN", unique = true, nullable = false, length = 60)
    private String nome;

    @Comment("CPF do cliente")
    @Column(name = "STR_CPF_CLN", nullable = false, length = 14)
    private String cpf;
}
