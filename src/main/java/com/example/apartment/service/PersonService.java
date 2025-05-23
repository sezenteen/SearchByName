package com.example.apartment.service;

import com.example.apartment.model.Person;
import com.example.apartment.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getALl() {
        return personRepository.findAll();
    }

    public Optional<Person> getById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> searchByName(String name) {
        return personRepository.findByNameContainingIgnoreCase(name);
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(Long id, Person updatedPerson) {
        return personRepository.findById(id).map(person -> {
            person.setName(updatedPerson.getName());
            person.setPhone(updatedPerson.getPhone());
            person.setEmail(updatedPerson.getEmail());
            return personRepository.save(person);
        }).orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
