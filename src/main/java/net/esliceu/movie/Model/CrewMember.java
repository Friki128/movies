package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_crew")
public class CrewMember {

    @EmbeddedId
    private CrewMemberId id;

    private String job;

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
}
