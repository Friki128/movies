package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="department")
public class Department implements Mappable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private int id;

    @Column(name="department_name")
    private String name;

    public Department(){}

    public Department(String name) {
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
