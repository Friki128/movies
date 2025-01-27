package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    Page<Movie> findAllByTitleContainsIgnoreCase(String title, Pageable pageable);

    @Query("SELECT DISTINCT m FROM movie m JOIN movie_cast mc ON m.id = mc.id.movie.id WHERE mc.id.person.id=:actor")
    Page<Movie> findAllMoviesByActor(@Param("actor")int actor, Pageable page);

    @Query("SELECT m FROM movie m JOIN movie_cast mc ON m.id = mc.id.movie.id WHERE mc.name=:character")
    Page<Movie> findAllMoviesByCharacter(@Param("character") String character, Pageable page);

    @Query("SELECT m FROM movie m JOIN movie_crew mc ON m.id = mc.id.movie.id WHERE mc.id.person.id=:director AND mc.job='Director'")
    Page<Movie> findAllMoviesByDirector(@Param("director") int director, Pageable page);

    @Query("SELECT DISTINCT m FROM movie m JOIN movie_genres mg ON m.id = mg.id.movie.id WHERE mg.id.genre.id=:genre")
    Page<Movie> findAllMoviesByGenre(@Param("genre") int genre, Pageable page);
}
