package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Keyword;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepo extends JpaRepository<Keyword, Integer> {
    Page<Keyword> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
