package br.com.compras.modules.produto.repository;

import br.com.compras.modules.produto.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

    Optional<ProdutoEntity> findByNomeIgnoreCase(String nome);
}
