package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Cast;
import net.esliceu.movie.Model.CastId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepo extends JpaRepository<Cast, CastId> {
}
