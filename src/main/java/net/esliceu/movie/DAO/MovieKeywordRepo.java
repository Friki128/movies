package net.esliceu.movie.DAO;

import jakarta.transaction.Transactional;
import net.esliceu.movie.Model.Keyword;
import net.esliceu.movie.Model.Movie;
import net.esliceu.movie.Model.MovieKeyword;
import net.esliceu.movie.Model.MovieKeywordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieKeywordRepo extends JpaRepository<MovieKeyword, MovieKeywordId> {
    List<MovieKeyword> findAllByIdMovie(Movie movie);

    List<MovieKeyword> findAllByIdKeyword(Keyword keyword);

    @Transactional
    void deleteAllByIdMovie(Movie movie);

    @Transactional
    void deleteAllByIdKeyword(Keyword keyword);
}
