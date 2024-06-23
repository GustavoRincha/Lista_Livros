package application.repository;

import org.springframework.data.repository.CrudRepository;
import application.model.Preco;

public interface PrecoRepository extends CrudRepository<Preco, Long> {
    
}