package com.whouse.simple.controller;

import com.whouse.simple.dto.PersonDTO;
import com.whouse.simple.dto.RequestPersonDTO;
import com.whouse.simple.entity.Person;
import com.whouse.simple.entity.Product;
import com.whouse.simple.error.NotFoundException;
import com.whouse.simple.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
    private final ModelMapper modelMapper;
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping
    @ResponseBody
    public List<PersonDTO> getAllPerson() {
        return service.getPersonList()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public PersonDTO findPersonById(@PathVariable("id")  @Min(0) Long id) throws NotFoundException {
        return convertToDto(getPerson(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody RequestPersonDTO person) {
        service.createPerson(convertToEntity(person));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable @Min(0) Long id, @RequestBody PersonDTO person) throws NotFoundException {
        getPerson(id);
        service.updatePerson(convertToEntity(person));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable @Min(0) Long id) throws NotFoundException {
        service.deletePerson(getPerson(id));
    }

    private Person getPerson(Long id) throws NotFoundException {
        Optional<Person> person = service.getPersonById(id);
        if (person.isEmpty()) throw new NotFoundException("Not find by id" + id.toString());
        return person.get();
    }

    private PersonDTO convertToDto(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }
    private Person convertToEntity(PersonDTO personDTO) {
        return  modelMapper.map(personDTO, Person.class);
    }
    private Person convertToEntity(RequestPersonDTO personDTO) {
        return  modelMapper.map(personDTO, Person.class);
    }

}
