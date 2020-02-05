package monitora.features.training.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Author {
    @Id
    private Integer id;
    @NotEmpty(message = "Campo nome é obrigatório")
    private String name;
    //@JsonFormat(pattern = "yyyy-MM-dd") format configured in application.properties
    private Date birth;

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
