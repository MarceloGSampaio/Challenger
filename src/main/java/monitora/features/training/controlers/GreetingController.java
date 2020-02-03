package monitora.features.training.controlers;

import monitora.features.training.models.Greeting;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private String template = "Welcome to the Sith Order, your id is ";

    @RequestMapping(path = "/authors/{id}")
    public Greeting greeting(@PathVariable("id") long id) {
        System.out.println(template+id);
        return new Greeting(template + id);
    }
}


