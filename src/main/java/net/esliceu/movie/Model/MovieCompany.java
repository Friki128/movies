package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_company")
public class MovieCompany implements MappableContainer{

    @EmbeddedId
    private MovieCompanyId id;

    public MovieCompany(){}

    public MovieCompany(MovieCompanyId id) {
        this.id = id;
    }

    public MovieCompanyId getId() {
        return id;
    }

    public void setId(MovieCompanyId id) {
        this.id = id;
    }

    @Override
    public Mappable getMappable(String name) {
        return switch (name){
            case "company" -> getId().getCompany();
            case "movie" -> getId().getMovie();
            default -> null;
        };
    }

    @Override
    public String print(String exclude) {
        return switch (exclude){
            case "movie" -> getId().getCompany().getName();
            default -> getId().getMovie().getName();
        };
    }
}
