package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    Page<Movie> findAllByTitleContainsIgnoreCase(String title, Pageable pageable);
}
