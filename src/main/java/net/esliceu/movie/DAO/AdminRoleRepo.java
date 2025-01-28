package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.AdminRole;
import net.esliceu.movie.Model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRoleRepo extends JpaRepository<AdminRole, Integer> {
    Page<AdminRole> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
