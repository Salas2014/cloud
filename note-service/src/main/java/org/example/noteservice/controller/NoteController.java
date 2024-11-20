package org.example.noteservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.noteservice.domain.Note;
import org.example.noteservice.repo.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteRepository noteRepository;

    @GetMapping("{personId}")
    public List<Note> findByPersonId(@PathVariable Long personId) {
        List<Note> allByPersonId = noteRepository.findAllByPersonId(personId);
        System.out.println(allByPersonId);
        return allByPersonId;
    }

    @PostMapping
    public Note createnote(@RequestBody Note note) {
        return noteRepository.save(note);
    }
}
