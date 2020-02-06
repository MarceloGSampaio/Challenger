package monitora.features.training.repository;

import monitora.features.training.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepository extends JpaRepository<Book, Integer> {
    Page<Book> findByAuthorId(Integer authorId, Pageable pageable);
    Optional<Book> findByIdAndAuthorId(Integer id, Integer authorId);
}
