package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Integer> {
}
