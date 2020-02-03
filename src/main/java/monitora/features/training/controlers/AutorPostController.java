package monitora.features.training.controlers;

import monitora.features.training.models.Author;
import monitora.features.training.models.Greeting;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AutorPostController {
    @PostMapping
    public Greeting greeting(@RequestBody Author author) {
        //SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(author.getBirth());
        return new Greeting(author.getName() + " was born in " + author.getBirth());
    }

}
