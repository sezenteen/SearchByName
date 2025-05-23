package com.example.apartment.controller;

import com.example.apartment.model.Person;
import com.example.apartment.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getALl();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.getById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @GetMapping("/search/{name}")
    public List<Person> searchByName(@PathVariable String name) {
        return personService.searchByName(name);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personService.update(id, updatedPerson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}
