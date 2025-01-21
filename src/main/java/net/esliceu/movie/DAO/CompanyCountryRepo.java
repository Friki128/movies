package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.CompanyCountry;
import net.esliceu.movie.Model.CompanyCountryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyCountryRepo extends JpaRepository<CompanyCountry, CompanyCountryId> {
}
