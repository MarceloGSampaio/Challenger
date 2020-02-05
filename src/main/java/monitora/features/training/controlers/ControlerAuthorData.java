package monitora.features.training.controlers;

import monitora.features.training.erros.ResourceNotFoundException;
import monitora.features.training.models.Author;
import monitora.features.training.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class ControlerAuthorData {

    @Autowired
    AuthorsRepository authorsDAO;

    @GetMapping("/all")
    public List<Author> getAll(){
        return authorsDAO.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable Integer id){
        verifyIfAuthorExists(id);
        Optional<Author> author = authorsDAO.findById(id);
        return author;
    }

    @PostMapping
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<?> save(@Valid @RequestBody Author author) {
        verifyIfAuthorNotExists(author.getId());
        return new ResponseEntity<>(authorsDAO.save(author), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        verifyIfAuthorExists(id);
        authorsDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Author author) {
        verifyIfAuthorExists(id);
        author.setId(id);
        authorsDAO.save(author);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    private void verifyIfAuthorExists(Integer id) {
        if (Objects.equals(authorsDAO.findById(id), Optional.empty()))
            throw new ResourceNotFoundException("Author not found for ID: " + id);
    }

    private void verifyIfAuthorNotExists(Integer id) {
        if (!Objects.equals(authorsDAO.findById(id), Optional.empty()))
            throw new ResourceNotFoundException("Author found for ID: " + id);
    }


}
