package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_keywords")
public class MovieKeyword {

    @EmbeddedId
    private MovieKeywordId id;

    public MovieKeyword(MovieKeywordId id) {
        this.id = id;
    }

    public MovieKeywordId getId() {
        return id;
    }

    public void setId(MovieKeywordId id) {
        this.id = id;
    }
}
