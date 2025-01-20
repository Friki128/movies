package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="production_country")
public class CompanyCountry {
    @EmbeddedId
    private CompanyCountryId id;

    public CompanyCountry(CompanyCountryId id) {
        this.id = id;
    }

    public CompanyCountryId getId() {
        return id;
    }

    public void setId(CompanyCountryId id) {
        this.id = id;
    }
}
