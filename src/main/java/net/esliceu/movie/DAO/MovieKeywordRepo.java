package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.MovieKeyword;
import net.esliceu.movie.Model.MovieKeywordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieKeywordRepo extends JpaRepository<MovieKeyword, MovieKeywordId> {
}
