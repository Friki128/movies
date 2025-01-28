package net.esliceu.movie.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RolePermissionId {
    @ManyToOne
    @JoinColumn(name="role_id")
    private AdminRole adminRole;
    @ManyToOne
    @JoinColumn(name="permission_id")
    private Permission permission;

    public RolePermissionId(){}

    public RolePermissionId(AdminRole adminRole, Permission permission) {
        this.adminRole = adminRole;
        this.permission = permission;
    }

    public AdminRole getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(AdminRole adminRole) {
        this.adminRole = adminRole;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
