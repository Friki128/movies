package net.esliceu.movie.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name="role_permission")
public class RolePermission implements MappableContainer{
    @EmbeddedId
    RolePermissionId id;

    public RolePermission(){}

    public RolePermission(RolePermissionId id) {
        this.id = id;
    }

    public RolePermissionId getId() {
        return id;
    }

    public void setId(RolePermissionId id) {
        this.id = id;
    }

    @Override
    public Mappable getMappable(String name) {
        return switch (name){
            case "permission" -> getId().getPermission();
            case "role" -> getId().getAdminRole();
            default -> null;
        };
    }

    @Override
    public String print(String exclude) {
        return switch (exclude){
            case "role" -> getId().getPermission().getName();
            default -> getId().getAdminRole().getName();
        };
    }
}
