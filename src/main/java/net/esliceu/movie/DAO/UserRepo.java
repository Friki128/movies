package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Person;
import net.esliceu.movie.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByNameAndPassword(String name, String password);
    Optional<User> findByName(String name);
    Page<User> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
