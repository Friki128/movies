package net.esliceu.movie.Model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class MovieLanguageId {

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name="language_role_id")
    private LanguageRole languageRole;

    public MovieLanguageId(){}

    public MovieLanguageId(Movie movie, Language language, LanguageRole languageRole) {
        this.movie = movie;
        this.language = language;
        this.languageRole = languageRole;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LanguageRole getLanguageRole() {
        return languageRole;
    }

    public void setLanguageRole(LanguageRole languageRole) {
        this.languageRole = languageRole;
    }
}
