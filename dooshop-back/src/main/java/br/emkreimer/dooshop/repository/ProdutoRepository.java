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
}
