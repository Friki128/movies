package net.esliceu.movie.Model;

import jakarta.persistence.*;

@Entity(name="movie_company")
public class MovieCompany {

    @EmbeddedId
    private MovieCompanyId id;

    public MovieCompany(MovieCompanyId id) {
        this.id = id;
    }

    public MovieCompanyId getId() {
        return id;
    }

    public void setId(MovieCompanyId id) {
        this.id = id;
    }
}
