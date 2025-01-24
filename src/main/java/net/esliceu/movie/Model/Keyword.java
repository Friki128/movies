package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="keyword")
public class Keyword implements Mappable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="keyword_id")
    private int id;

    @Column(name="keyword_name")
    private String name;

    public Keyword(){}

    public Keyword(String name) {
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
