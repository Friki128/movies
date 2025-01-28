package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_cast")
public class Cast implements MappableContainer, Mappable{

    @EmbeddedId
    private CastId id;

    @Column(name="character_name", length = 400)
    private String name;

    @Column(name="cast_order")
    private int order;

    public Cast(){}

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

    public CastId getCastId() {
        return id;
    }

    public int getId(){
        return 1;
    }

    public void setId(CastId id) {
        this.id = id;
    }

    @Override
    public Mappable getMappable(String name) {
        return switch (name) {
            case "person" -> getCastId().getPerson();
            case "movie" -> getCastId().getMovie();
            case "gender" -> getCastId().getGender();
            default -> null;
        };
    }

    @Override
    public String print(String exclude) {
        return switch (exclude){
            case "person" -> this.getName() + " in " + this.getCastId().getMovie().getTitle() + ". Gender: " + this.getCastId().getGender().getName();
            case "movie" -> this.getCastId().getPerson().getName() + " As " + this.getName() + ". Gender: " + this.getCastId().getGender().getName();
            default -> this.getCastId().getPerson().getName() + " As " + this.getName() + " in " + this.getCastId().getMovie().getTitle();
        };
    }

    @Override
    public String url() {
        return "?movie=" + getCastId().getMovie().getId() + "&person=" + getCastId().getPerson().getId() + "&gender=" + getCastId().getGender().getId();
    }
}
