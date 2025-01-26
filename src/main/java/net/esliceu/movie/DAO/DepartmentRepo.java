package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    Page<Department> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
