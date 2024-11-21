package org.salas.person.service.service;

import lombok.RequiredArgsConstructor;
import org.salas.person.service.client.FeignNoteClient;
import org.salas.person.service.domain.Person;
import org.salas.person.service.dto.Note;
import org.salas.person.service.dto.PersonDto;
import org.salas.person.service.repo.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final FeignNoteClient feignNoteClient;
    private final PersonRepository personRepository;


    public PersonDto findAllWithNotes(Long personId) {
        Person person = personRepository.findById(personId).orElseThrow();

        List<Note> allNoteByPersonId = getNotes(personId);
        System.out.println(allNoteByPersonId);
        return new PersonDto(person.getFirstName(), person.getLastName(), allNoteByPersonId);
    }

    public List<Note> getNotes(Long personId) {
        return feignNoteClient.findAllNoteByPersonId(personId);
    }


    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
