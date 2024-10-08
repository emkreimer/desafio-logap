package br.emkreimer.dooshop.repository;

import br.emkreimer.dooshop.domain.model.Empresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

    @Query("SELECT e FROM Empresa e")
    public List<Empresa> findAll();

    @Query("SELECT e FROM Empresa e JOIN e.produtos p WHERE p.estoque = 0")
    public List<Empresa> getAllSemEstoque();

    @Query("SELECT SUM(p.estoque) FROM Produto p JOIN p.fornecedores f WHERE f.id = ?1")
    public Integer getEstoqueByFornecedor(Integer id);
}
