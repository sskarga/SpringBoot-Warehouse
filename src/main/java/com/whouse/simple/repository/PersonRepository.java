package com.whouse.simple.repository;

import com.whouse.simple.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
