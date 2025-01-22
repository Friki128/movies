package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private int id;

    @Column(name="country_iso_code")
    private String isoCode;

    @Column(name="country_name")
    private String name;

    public Country(String isoCode, String name) {
        this.isoCode = isoCode;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
