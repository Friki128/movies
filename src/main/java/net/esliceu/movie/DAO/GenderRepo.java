package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepo extends JpaRepository<Gender, Integer> {
}
