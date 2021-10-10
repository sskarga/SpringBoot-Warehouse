package com.whouse.simple.repository;

import com.whouse.simple.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByNameContainsIgnoreCase(String name);
    Optional<Person> findById(long id);

    @Override
    List<Person> findAll();
}
