package br.emkreimer.dooshop.repository;

import br.emkreimer.dooshop.domain.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository  extends CrudRepository<Produto, Integer> {

    @Override
    @Query("FROM Produto ORDER BY nome")
    public List<Produto> findAll();

    @Query("FROM Produto WHERE estoque = 0")
    public List<Produto> getProdutosFaltantes();

    @Query("SELECT p FROM Produto p JOIN p.fornecedores f WHERE f.id = ?1")
    public List<Produto> getProdutosByFornecedor(Integer id);

    @Query(value = "SELECT p.categoria AS c, COUNT(p) AS count FROM Produto p GROUP BY c")
    public List<Object[]> countProductsByCategoria();

    @Query("SELECT p.categoria AS c, SUM(p.estoque) FROM Produto p GROUP BY c")
    public List<Object[]> getEstoqueGroupedByCategoria();

}
