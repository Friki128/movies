package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Country;
import net.esliceu.movie.Model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {
    Page<Country> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
