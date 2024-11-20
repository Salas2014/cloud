package org.salas.person.service.controller;

import lombok.RequiredArgsConstructor;
import org.salas.person.service.domain.Person;
import org.salas.person.service.dto.PersonDto;
import org.salas.person.service.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/{personId}")
    public PersonDto findWithNotes(@PathVariable Long personId) {
        return personService.findAllWithNotes(personId);
    }
}
