package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="language_role")
public class LanguageRole implements Mappable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private int id;

    @Column(name="language_role")
    private String role;

    public LanguageRole(){}

    public LanguageRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return this.role;
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
