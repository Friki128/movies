package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.LanguageRole;
import net.esliceu.movie.Model.MovieLanguage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRoleRepo extends JpaRepository<LanguageRole, Integer> {
    Page<LanguageRole> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
