package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_genres")
public class MovieGenre implements MappableContainer{

    @EmbeddedId
    private MovieGenreId id;

    public MovieGenre(MovieGenreId id) {
        this.id = id;
    }

    public MovieGenreId getId() {
        return id;
    }

    public void setId(MovieGenreId id) {
        this.id = id;
    }

    @Override
    public Mappable getMappable(String name) {
        return switch (name){
            case "genre" -> getId().getGenre();
            case "movie" -> getId().getMovie();
            default -> null;
        };
    }
}
