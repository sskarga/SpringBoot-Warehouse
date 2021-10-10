package com.whouse.simple.service;

import com.whouse.simple.entity.Person;
import com.whouse.simple.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImp implements PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonServiceImp(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> getPersonList() {
        return repository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Person> getPersonByName(String name) {
        return repository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public Person createPerson(Person person) {
        return repository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return repository.save(person);
    }

    @Override
    public void deletePerson(Person person) {

    }
}
