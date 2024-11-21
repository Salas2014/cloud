package org.salas.person.service.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.salas.person.service.dto.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "notes")
public interface FeignNoteClient {

    @GetMapping("/notes/{personId}")
    @CircuitBreaker(name = "notes-breaker", fallbackMethod = "fallBackNoteByPersonId")
    List<Note> findAllNoteByPersonId(@PathVariable Long personId);

    default List<Note> fallBackNoteByPersonId(Long personId, Throwable t) {
        System.out.println("Fallback method called due to: " + t.getMessage());
        return List.of(new Note(-1L, "DEFAULT"));
    }
}
