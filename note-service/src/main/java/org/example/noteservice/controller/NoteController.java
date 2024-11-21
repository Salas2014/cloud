package org.example.noteservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.noteservice.domain.Note;
import org.example.noteservice.repo.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteRepository noteRepository;

    @SneakyThrows
    @GetMapping("{personId}")
    public List<Note> findByPersonId(@PathVariable Long personId) {
        Thread.sleep(2500);
        return noteRepository.findAllByPersonId(personId);
    }

    @PostMapping
    public Note createnote(@RequestBody Note note) {
        return noteRepository.save(note);
    }
}
