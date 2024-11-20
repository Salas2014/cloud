package org.salas.person.service.client;

import org.salas.person.service.dto.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "notes")
public interface FeignNoteClient {

    @GetMapping("/notes/{personId}")
    List<Note> findAllNoteByPersonId(@PathVariable Long personId);
}
