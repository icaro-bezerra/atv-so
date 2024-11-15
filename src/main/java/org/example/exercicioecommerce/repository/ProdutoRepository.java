package org.example.exercicioecommerce.repository;

import org.example.exercicioecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByCategoriaEqualsIgnoreCaseAndPrecoVendaBetween(String categoria, Double valorInicial, Double valorFinal);
    List<Produto> findByQtdVendidosGreaterThanEqual(Integer quantidade);
}
