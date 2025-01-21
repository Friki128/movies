package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.MovieLanguage;
import net.esliceu.movie.Model.MovieLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieLanguageRepo extends JpaRepository<MovieLanguage, MovieLanguageId> {
}
