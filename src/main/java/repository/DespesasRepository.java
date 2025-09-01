package repository;

import org.springframework.data.repository.ListCrudRepository;

import models.Despesas;

public interface DespesasRepository extends ListCrudRepository<Despesas, Integer> {

}
