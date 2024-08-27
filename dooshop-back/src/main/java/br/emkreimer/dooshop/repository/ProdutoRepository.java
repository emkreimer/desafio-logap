package br.emkreimer.dooshop.repository;

import br.emkreimer.dooshop.domain.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends CrudRepository<Produto, Integer> {

}
