package net.esliceu.movie.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name="movie")
public class Movie implements Mappable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private int id;

    private String title;

    private int budget;

    private String homepage;

    @Column(length = 1000)
    private String overview;

    private double popularity;

    @Column(name="release_date")
    private Date releaseDate;

    private long revenue;

    private int runtime;

    @Column(name="movie_status")
    private String status;

    private String tagline;

    @Column(name="vote_average")
    private double voteAverage;

    @Column(name="vote_count")
    private int voteCount;

    public Movie(String title, int budget, String homepage, String overview, double popularity, Date releaseDate, long revenue, int runtime, String status, String tagline, double voteAverage, int voteCount) {
        this.title = title;
        this.budget = budget;
        this.homepage = homepage;
        this.overview = overview;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.status = status;
        this.tagline = tagline;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return this.title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
