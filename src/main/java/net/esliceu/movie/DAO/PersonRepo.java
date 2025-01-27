package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    Page<Person> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
    @Query("SELECT DISTINCT p FROM person p JOIN movie_cast mc ON p.id = mc.id.person.id")
    List<Person> findAllActors();
    @Query("SELECT DISTINCT p FROM person p JOIN movie_crew mc ON p.id = mc.id.person.id AND mc.job=\"Director\"")
    List<Person> findAllDirectors();
}
