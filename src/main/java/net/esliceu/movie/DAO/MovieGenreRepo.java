package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.MovieGenre;
import net.esliceu.movie.Model.MovieGenreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieGenreRepo extends JpaRepository<MovieGenre, MovieGenreId> {
}
