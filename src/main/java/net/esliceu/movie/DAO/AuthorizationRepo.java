package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.Authorization;
import net.esliceu.movie.Model.AuthorizationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepo extends JpaRepository<Authorization, AuthorizationId> {
}
