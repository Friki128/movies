package net.esliceu.movie.DAO;

import jakarta.transaction.Transactional;
import net.esliceu.movie.Model.Authorization;
import net.esliceu.movie.Model.AuthorizationId;
import net.esliceu.movie.Model.Permission;
import net.esliceu.movie.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepo extends JpaRepository<Authorization, AuthorizationId> {
    @Transactional
    void deleteAllByIdUser(User user);

    @Transactional
    void deleteAllByIdPermission(Permission permission);
}
