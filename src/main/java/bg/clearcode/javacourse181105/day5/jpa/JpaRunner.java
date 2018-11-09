package bg.clearcode.javacourse181105.day5.jpa;

import bg.clearcode.javacourse181105.day5.jpa.model.Company;
import bg.clearcode.javacourse181105.day5.jpa.model.EmbeddableSampleClass;
import bg.clearcode.javacourse181105.day5.jpa.model.Gender;
import bg.clearcode.javacourse181105.day5.jpa.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Iva Koleva, ClearCode Ltd. on 09.11.2018,
 * a significant bit of leva.bg project.
 */
public class JpaRunner {
    public static void main(final String[] args) {
        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("Javacourse181105PersistenceUnit");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        final Person person = new Person();
        person.setDateOfBirth(LocalDate.of(1995, Month.APRIL, 11));
        person.setName("Georgi");
        person.setGender(Gender.MALE);
        person.setSkillSet(new HashSet<>(Arrays.asList("Java", "Java SE", "JPA")));
        final EmbeddableSampleClass embeddableSampleClass = new EmbeddableSampleClass();
        embeddableSampleClass.setValue("our value");
        person.setEmbeddableSampleClass(embeddableSampleClass);

        final Company company = new Company();
        person.setCompany(company);

        company.setName("ClearCode");
        company.setDescription("");
        company.setPersonCollection(Arrays.asList(person));

        entityManager.getTransaction().begin();
        try {
            entityManager.persist(person);
            //entityManager.persist(company);
            /*entityManager.createNamedQuery("findAllPersons", Person.class)
                    .setParameter("personName", "Georgi")
                    .getResultList().forEach(System.out::println);*/

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

        System.exit(0);
        //entityManager.
    }
}
