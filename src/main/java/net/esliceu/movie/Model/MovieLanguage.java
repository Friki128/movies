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
}
