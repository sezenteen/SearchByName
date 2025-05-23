package com.example.apartment.repository;

import com.example.apartment.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>  {
    List<Person> findByNameContainingIgnoreCase(String name);

    Long id(Long id);
}
