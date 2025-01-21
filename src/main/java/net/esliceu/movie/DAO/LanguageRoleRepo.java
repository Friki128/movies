package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.LanguageRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRoleRepo extends JpaRepository<LanguageRole, Integer> {
}
