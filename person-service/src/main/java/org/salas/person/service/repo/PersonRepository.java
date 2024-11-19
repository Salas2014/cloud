package org.salas.person.service.repo;

import org.salas.person.service.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

//    @Override
//    @Query("select distinct p from Person p left join fetch p.notes")
//    List<org.salas.person.service.domain.Person> findAll();
}
