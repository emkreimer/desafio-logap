package br.emkreimer.dooshop.repository;

import br.emkreimer.dooshop.domain.model.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
}
