package bg.clearcode.javacourse181105.day5.jpa.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 09.11.2018,
 * a significant bit of leva.bg project.
 */
@Entity
@Table(indexes = {@Index(columnList = "name")})
// JPQL
@NamedQueries({@NamedQuery(name = "findAllPersons", query = "select p from Person p  where p.name = :personName")})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Basic(optional = false)
    @Column(length = 300, nullable = false)
    private String name;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Company company;

    @ElementCollection
    private Set<String> skillSet;

    @Embedded
    private EmbeddableSampleClass embeddableSampleClass;

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<String> skillSet) {
        this.skillSet = skillSet;
    }

    public EmbeddableSampleClass getEmbeddableSampleClass() {
        return embeddableSampleClass;
    }

    public void setEmbeddableSampleClass(EmbeddableSampleClass embeddableSampleClass) {
        this.embeddableSampleClass = embeddableSampleClass;
    }
}
