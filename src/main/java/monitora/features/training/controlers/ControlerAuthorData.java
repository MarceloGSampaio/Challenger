package monitora.features.training.controlers;

import monitora.features.training.erros.ResourceNotFoundException;
import monitora.features.training.models.Author;
import monitora.features.training.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ControlerAuthorData {

    @Autowired
    AuthorsRepository authorsRepository;

    @GetMapping("/authors")
    public Page<Author> getAllAuthors(Pageable pageable) {
        return authorsRepository.findAll(pageable);
    }

    @GetMapping("/authors/{authorId}")
    public Author getAuthorById(@PathVariable Integer authorId) {
        return authorsRepository.findById(authorId).
                orElseThrow(() -> new ResourceNotFoundException("AuthorId " + authorId + " not found"));
    }


    @PostMapping("/authors")
    public Author createAuthor(@Valid @RequestBody Author author) {
        return authorsRepository.save(author);
    }

    @PutMapping("/authors/{authorId}")
    public Author updateAuthor (@PathVariable Integer authorId, @Valid @RequestBody Author authorRequest){
        return authorsRepository.findById(authorId).map(author -> {
            author.setName(authorRequest.getName());
            author.setBirth(authorRequest.getBirth());
            return authorsRepository.save(author);
        }).orElseThrow(() -> new ResourceNotFoundException("AuthorId " + authorId + " not found"));
    }

    @DeleteMapping("/authors/{authorId}")
    public ResponseEntity<?> deleteAuthor (@PathVariable Integer authorId){
        return authorsRepository.findById(authorId).map(author -> {
            authorsRepository.delete(author);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("AuthorId " + authorId + " not found"));
    }

}