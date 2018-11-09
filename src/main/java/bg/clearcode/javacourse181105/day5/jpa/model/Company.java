package bg.clearcode.javacourse181105.day5.jpa.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 09.11.2018,
 * a significant bit of leva.bg project.
 */
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Lob
    private String description;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private Collection<Person> personCollection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }
}
