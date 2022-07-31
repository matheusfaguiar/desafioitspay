package aguiar.matheus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aguiar.matheus.model.Cartoes; 

@Repository
public interface CartoesRepository extends CrudRepository<Cartoes, Integer>{
}  