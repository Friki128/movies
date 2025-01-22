package net.esliceu.movie.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="permission_id")
    private int id;

    @Column(name="permission_name")
    private String name;

    public Permission(String name) {
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
