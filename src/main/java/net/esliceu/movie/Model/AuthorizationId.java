package net.esliceu.movie.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class AuthorizationId {

    @ManyToOne
    @JoinColumn(name="permission_id")
    private Permission permission;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public AuthorizationId(Permission permission, User user) {
        this.permission = permission;
        this.user = user;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
