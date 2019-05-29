package com.daniel.navas.controller;

import com.daniel.navas.domain.Person;
import com.daniel.navas.services.PersonService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j
@RequestMapping(path = "/")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/personas")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PostMapping(value = "/personas")
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping(value = "/personas/{id}")
    public Person edit(@RequestBody Person person, @PathVariable Long id) {
        if (personService.exists(id)) {
            Person per = personService.findById(id);
            per.setNombre(person.getNombre());
            per.setApellido(person.getApellido());
            return personService.save(per);
        } else {
            return personService.save(person);
        }
    }

    @DeleteMapping(value = "/personas/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}
