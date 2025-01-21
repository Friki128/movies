package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.MovieCompany;
import net.esliceu.movie.Model.MovieCompanyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCompanyRepo extends JpaRepository<MovieCompany, MovieCompanyId> {
}
