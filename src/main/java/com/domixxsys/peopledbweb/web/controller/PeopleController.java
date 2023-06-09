package com.domixxsys.peopledbweb.web.controller;

import com.domixxsys.peopledbweb.biz.model.Person;
import com.domixxsys.peopledbweb.data.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople(){
        return personRepository.findAll();
    }

    @ModelAttribute
    public Person getPerson() {
        return new Person();
    }
    @GetMapping
    public String showPeoplePage(){
        return "people";
    }

    @PostMapping
    public String savePerson(@Valid Person person, Errors errors){
        System.out.println(person);

        if(!errors.hasErrors()){
            personRepository.save(person);
            return "redirect:people";
        }

        return "people";

    }

    @PostMapping(params = "delete=true")
    public String deletePeople(@RequestParam Optional<List<Long>>  selections){
        selections.ifPresent(personRepository::deleteAllById);

        return "redirect:people";
    }

    @PostMapping(params = "edit=true")
    public String editPerson(@RequestParam Optional<List<Long>>  selections, Model model){
        if(selections.isPresent()){
            Optional<Person> person = personRepository.findById(selections.get().get(0));
            model.addAttribute("person", person);

        }

        return "people";
    }
}
