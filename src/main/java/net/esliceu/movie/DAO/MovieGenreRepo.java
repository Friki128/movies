package net.esliceu.movie.DAO;

import jakarta.transaction.Transactional;
import net.esliceu.movie.Model.Genre;
import net.esliceu.movie.Model.Movie;
import net.esliceu.movie.Model.MovieGenre;
import net.esliceu.movie.Model.MovieGenreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieGenreRepo extends JpaRepository<MovieGenre, MovieGenreId> {
    List<MovieGenre> findAllByIdMovie(Movie movie);

    List<MovieGenre> findAllByIdGenre(Genre genre);

    @Transactional
    void deleteAllByIdMovie(Movie movie);

    @Transactional
    void deleteAllByIdGenre(Genre genre);
}
