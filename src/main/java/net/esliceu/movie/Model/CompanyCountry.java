package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="production_country")
public class CompanyCountry implements MappableContainer{
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

    @Override
    public Mappable getMappable(String name) {
        return switch (name){
            case "movie" -> getId().getMovie();
            case "country" -> getId().getCountry();
            default -> null;
        };
    }
}
