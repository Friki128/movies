package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Company;
import net.esliceu.movie.Model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {
    Page<Company> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
