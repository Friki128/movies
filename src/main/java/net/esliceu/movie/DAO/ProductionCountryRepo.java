package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionCountryRepo extends JpaRepository<ProductionCountry, ProductionCountryId> {
    List<ProductionCountry> findAllByIdCountry(Country country);

    List<ProductionCountry> findAllByIdMovie(Movie movie);
}
