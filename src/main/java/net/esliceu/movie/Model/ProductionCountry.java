package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="production_country")
public class ProductionCountry implements MappableContainer{
    @EmbeddedId
    private ProductionCountryId id;

    public ProductionCountry(){}

    public ProductionCountry(ProductionCountryId id) {
        this.id = id;
    }

    public ProductionCountryId getId() {
        return id;
    }

    public void setId(ProductionCountryId id) {
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

    @Override
    public String print(String exclude) {
        return switch (exclude){
            case "movie" -> getId().getCountry().getName();
            default -> getId().getMovie().getName();
        };
    }

    @Override
    public String url() {
        return "?country=" + getId().getCountry().getId() + "&movie=" + getId().getMovie().getId();
    }
}
