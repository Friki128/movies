package net.esliceu.movie.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="authorization")
public class Authorization {

    @EmbeddedId
    private AuthorizationId id;

    @Column(name="authorization_status")
    private String status;

    public Authorization(AuthorizationId id, String status) {
        this.id = id;
        this.status = status;
    }

    public AuthorizationId getId() {
        return id;
    }

    public void setId(AuthorizationId id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
