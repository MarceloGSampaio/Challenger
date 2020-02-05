package monitora.features.training.repository;

import monitora.features.training.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Author, Integer> {

}
