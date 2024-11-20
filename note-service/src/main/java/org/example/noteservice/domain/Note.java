package org.example.noteservice.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "notes")
@NoArgsConstructor
@Generated @Setter
@ToString
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Long personId;
}
