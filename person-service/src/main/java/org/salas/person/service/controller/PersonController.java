package org.salas.person.service.controller;

import lombok.RequiredArgsConstructor;
import org.salas.person.service.domain.Person;
import org.salas.person.service.repo.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
