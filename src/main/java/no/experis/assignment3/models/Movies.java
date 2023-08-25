package no.experis.assignment3.models;

import jakarta.persistence.*;

import java.net.URL;

@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", length = 255, nullable = false)
    private int id;
    @Column(name = "title", length = 255, nullable = false)
    private String title;
    @Column(name = "genre", length = 255, nullable = false)
    private String genre;
    @Column(name = "year", length = 255, nullable = false)
    private int year;
    @Column(name = "director", length = 255, nullable = false)
    private String director;
    @Column(name = "poster", length = 255, nullable = false)
    private URL poster;
    @Column(name = "trailer", length = 255, nullable = false)
    private URL trailer;


    public Movies() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public URL getPoster() {
        return poster;
    }

    public void setPoster(URL poster) {
        this.poster = poster;
    }

    public URL getTrailer() {
        return trailer;
    }

    public void setTrailer(URL trailer) {
        this.trailer = trailer;
    }
}
