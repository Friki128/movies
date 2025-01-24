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
}
