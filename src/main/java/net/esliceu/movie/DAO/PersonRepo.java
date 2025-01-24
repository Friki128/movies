package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    Page<Person> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
