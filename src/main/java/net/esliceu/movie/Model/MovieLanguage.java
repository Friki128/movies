package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_languages")
public class MovieLanguage implements MappableContainer{

    @EmbeddedId
    private MovieLanguageId id;

    public MovieLanguage(){}

    public MovieLanguage(MovieLanguageId id) {
        this.id = id;
    }

    public MovieLanguageId getId() {
        return id;
    }

    public void setId(MovieLanguageId id) {
        this.id = id;
    }

    @Override
    public Mappable getMappable(String name) {
        return switch (name){
          case "language" -> getId().getLanguage();
          case "movie" -> getId().getMovie();
          case "languageRole" -> getId().getLanguageRole();
            default -> null;
        };
    }

    @Override
    public String print(String exclude) {
        return switch (exclude){
            case "role" -> this.getId().getMovie().getTitle() + " in " + this.getId().getLanguage().getName();
            case "movie" -> this.getId().getLanguage().getName() + " " + this.getId().getLanguageRole().getName();
            default -> this.getId().getMovie().getTitle() + " " +this.getId().getLanguageRole().getName();
        };
    }

}
