package net.esliceu.movie.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="gender")
public class Gender implements Mappable{

    @Id
    @Column(name="gender_id")
    private int id;

    @Column(name="gender")
    private String name;

    public Gender(){}

    public Gender(int id, String name) {
        this.id = id;
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
