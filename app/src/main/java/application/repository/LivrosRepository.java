package application.repository;

import org.springframework.data.repository.CrudRepository;
import application.model.Livros;

public interface LivrosRepository extends CrudRepository<Livros, Long> {
    
}