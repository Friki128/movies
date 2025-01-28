package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="admin_role")
public class AdminRole implements Mappable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id")
    private int id;
    @Column(name="role_name")
    private String name;

    public AdminRole(){}

    public AdminRole(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
