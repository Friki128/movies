package net.esliceu.movie.DAO;

import jakarta.transaction.Transactional;
import net.esliceu.movie.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepo extends JpaRepository<RolePermission, RolePermissionId> {
    @Transactional
    void deleteAllByIdPermission(Permission permission);

    @Transactional
    void deleteAllByIdAdminRole(AdminRole adminRole);

    List<RolePermission> findAllByIdAdminRole(AdminRole adminRole);

    List<RolePermission> findAllByIdPermission(Permission permission);

}
