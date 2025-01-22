package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="language_role")
public class LanguageRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private int id;

    @Column(name="language_role")
    private String role;

    public LanguageRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
