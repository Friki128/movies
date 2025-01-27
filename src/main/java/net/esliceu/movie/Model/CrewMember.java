package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_crew")
public class CrewMember implements MappableContainer{

    @EmbeddedId
    private CrewMemberId id;

    private String job;

    public CrewMember(){}

    public CrewMember(CrewMemberId id, String job) {
        this.id = id;
        this.job = job;
    }

    public CrewMemberId getId() {
        return id;
    }

    public void setId(CrewMemberId id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public Mappable getMappable(String name) {
        return switch (name){
            case "department" -> getId().getDepartment();
            case "person" -> getId().getPerson();
            case "movie" -> getId().getMovie();
            default -> null;
        };
    }

    @Override
    public String print(String exclude) {
        return switch (exclude) {
            case "person" ->
                    this.getJob() + " as " + this.getId().getDepartment().getName() + " at " + this.getId().getMovie().getName();
            case "movie" ->
                    this.getId().getPerson().getName() + " as " + this.getJob() + " at " + this.getId().getDepartment().getName();
            default -> this.getId().getPerson().getName() + " in " + this.getId().getMovie().getTitle();
        };
    }
}
