package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_languages")
public class MovieLanguage {

    @EmbeddedId
    private MovieLanguageId id;

    public MovieLanguage(MovieLanguageId id) {
        this.id = id;
    }

    public MovieLanguageId getId() {
        return id;
    }

    public void setId(MovieLanguageId id) {
        this.id = id;
    }
}
