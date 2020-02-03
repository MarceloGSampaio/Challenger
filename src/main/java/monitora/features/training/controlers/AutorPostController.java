package monitora.features.training.controlers;

import monitora.features.training.models.Author;
import monitora.features.training.models.Greeting;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/author")
public class AutorPostController {
    @PostMapping
    public Greeting greeting(@Valid @RequestBody Author author) {
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(author.getBirth());
        return new Greeting(author.getName() + " was born in " + dateFormat.format(author.getBirth()));
    }

}
