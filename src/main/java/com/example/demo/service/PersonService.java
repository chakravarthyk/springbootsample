package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person getPerson(Long id){
        Optional<Person> personOptional = repository.findById(id);
        if(personOptional.isPresent()){
            return personOptional.get();
        }
        return null;
    }

    public Person createPerson(Person person){
        return repository.save(person);
    }

    public Person updatePerson(Person person){
        return repository.save(person);
    }

    public void deletePerson(Person person){
        repository.delete(person);
    }

}
