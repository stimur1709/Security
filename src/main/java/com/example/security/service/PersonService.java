package com.example.security.service;

import com.example.security.models.Person;
import com.example.security.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> findByUsername(String username) {
        return personRepository.findPersonByUsername(username);
    }

    @Transactional
    public void register(Person person) {
        personRepository.save(person);
    }
}