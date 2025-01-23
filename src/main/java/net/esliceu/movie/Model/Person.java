package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="person")
public class Person implements Mappable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id")
    private int id;

    @Column(name="person_name")
    private String name;

    public Person(String name) {
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
