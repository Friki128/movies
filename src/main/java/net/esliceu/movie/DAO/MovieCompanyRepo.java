package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Company;
import net.esliceu.movie.Model.Movie;
import net.esliceu.movie.Model.MovieCompany;
import net.esliceu.movie.Model.MovieCompanyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieCompanyRepo extends JpaRepository<MovieCompany, MovieCompanyId> {
    List<MovieCompany> findAllByIdMovie(Movie movie);

    List<MovieCompany> findAllByIdCompany(Company company);
}
