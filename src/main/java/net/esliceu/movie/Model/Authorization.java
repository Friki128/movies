package net.esliceu.movie.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="authorization")
public class Authorization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="authorization_id")
    private int id;

    @Column(name="authorization_status")
    private String status;

    @ManyToOne
    @JoinColumn(name="permission_id")
    private  Permission permission;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Authorization(int id, String status, Permission permission, User user) {
        this.id = id;
        this.status = status;
        this.permission = permission;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
