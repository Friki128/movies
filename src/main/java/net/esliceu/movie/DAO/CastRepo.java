package net.esliceu.movie.DAO;

import jakarta.transaction.Transactional;
import net.esliceu.movie.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CastRepo extends JpaRepository<Cast, CastId> {
    List<Cast> findAllByIdMovie(Movie movie);

    List<Cast> findAllByIdPerson(Person person);

    List<Cast> findAllByIdGender(Gender gender);

    @Transactional
    void deleteAllByIdMovie(Movie movie);

    @Transactional
    void deleteAllByIdGender(Gender gender);

    @Transactional
    void deleteAllByIdPerson(Person person);
}
