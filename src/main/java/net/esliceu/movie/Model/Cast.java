package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_cast")
public class Cast implements MappableContainer{

    @EmbeddedId
    private CastId id;

    @Column(name="character_name", length = 400)
    private String name;

    @Column(name="cast_order")
    private int order;

    public Cast(CastId id ,String name, int order) {
        this.name = name;
        this.order = order;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public CastId getId() {
        return id;
    }

    public void setId(CastId id) {
        this.id = id;
    }

    @Override
    public Mappable getMappable(String name) {
        return switch (name) {
            case "person" -> getId().getPerson();
            case "movie" -> getId().getMovie();
            case "gender" -> getId().getGender();
            default -> null;
        };
    }
}
