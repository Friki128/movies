package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Permission;
import net.esliceu.movie.Model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Integer> {
    Page<Permission> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
