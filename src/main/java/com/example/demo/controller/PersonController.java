package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.exception.ApplicationException;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("/")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("{id}")
    public Person getPerson(@PathVariable("id") Long id) {
        return personService.getPerson(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable("id") Long id) throws ApplicationException {
        try {
            Person person = new Person();
            person.setId(id);
            personService.deletePerson(person);
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }
}
