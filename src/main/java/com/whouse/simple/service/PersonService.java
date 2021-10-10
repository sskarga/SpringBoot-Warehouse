package com.whouse.simple.service;

import com.whouse.simple.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getPersonList();
    Optional<Person> getPersonById(Long id);
    List<Person> getPersonByName(String name);

    Person createPerson(Person person);
    Person updatePerson(Person person);
    void deletePerson(Person person);
}
