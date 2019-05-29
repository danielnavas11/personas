package com.daniel.navas.services;

import com.daniel.navas.domain.Person;
import com.daniel.navas.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void delete(Long id) {
        personRepository.delete(id);
    }

    public Person findById(Long id) {
        return personRepository.findOne(id);
    }

    public boolean exists(Long id) {
        return personRepository.exists(id);
    }


}
