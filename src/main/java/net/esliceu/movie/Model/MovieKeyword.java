package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_keywords")
public class MovieKeyword implements MappableContainer{

    @EmbeddedId
    private MovieKeywordId id;

    public MovieKeyword(){}

    public MovieKeyword(MovieKeywordId id) {
        this.id = id;
    }

    public MovieKeywordId getId() {
        return id;
    }

    public void setId(MovieKeywordId id) {
        this.id = id;
    }

    @Override
    public Mappable getMappable(String name) {
        return switch (name){
            case "movie" -> getId().getMovie();
            case "keyword" -> getId().getKeyword();
            default -> null;
        };
    }

    @Override
    public String print(String exclude) {
        return switch (exclude){
            case "movie" -> getId().getKeyword().getName();
            default -> getId().getMovie().getName();
        };
    }

    @Override
    public String url() {
        return "?movie=" + getId().getMovie().getId() + "&keyword=" + getId().getKeyword().getId();
    }
}
