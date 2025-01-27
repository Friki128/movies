package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieLanguageRepo extends JpaRepository<MovieLanguage, MovieLanguageId> {
    List<MovieLanguage> findAllByIdMovie(Movie movie);

    List<MovieLanguage> findAllByIdLanguage(Language language);

    List<MovieLanguage> findAllByIdLanguageRole(LanguageRole languageRole);
}
