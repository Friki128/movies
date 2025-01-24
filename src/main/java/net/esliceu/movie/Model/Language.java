package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="language")
public class Language implements Mappable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id")
    private int id;

    @Column(name="language_code")
    private String code;

    @Column(name="language_name")
    private String name;

    public Language(){}

    public Language(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
