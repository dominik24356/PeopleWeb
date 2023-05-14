package com.domixxsys.peopledbweb.data;

import com.domixxsys.peopledbweb.biz.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@Component
public class PersonDataLoader implements ApplicationRunner {
    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            List<Person> people = List.of(
                    new Person(null, "Jacob", "Comarch",
                            LocalDate.of(2002, 4, 30), new BigDecimal("20000"),"user@email.com"),
                    new Person(null, "Taco", "Hemingway",
                            LocalDate.of(2002, 4, 30), new BigDecimal("20000"),"user@email.com"),
                    new Person(null, "Emilica", "Pawelica",
                            LocalDate.of(2005, 4, 5), new BigDecimal("20000"),"user@email.com"),
                    new Person(null, "twoj", "stary",
                            LocalDate.of(1957, 4, 11), new BigDecimal("220000"),"user@email.com"),
                    new Person(null, "twoja", "stara",
                            LocalDate.of(1999, 4, 30), new BigDecimal("550000"),"user@email.com"),
                    new Person(null, "iksde", "coonrobi",
                            LocalDate.of(2000, 4, 22), new BigDecimal("1001"),"user@email.com")
            );

            personRepository.saveAll(people);
        }
    }
}
