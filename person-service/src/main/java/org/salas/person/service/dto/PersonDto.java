package org.salas.person.service.dto;

import java.util.List;

public record PersonDto(String firstName, String lastName, List<Note> notes) {
}
