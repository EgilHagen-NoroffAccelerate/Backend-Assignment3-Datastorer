package no.experis.assignment3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", length = 255, nullable = false)
    private int id;
    @Column(length = 255, nullable = false)
    private String title;
    @Column(length = 255, nullable = false)
    private String genre;
    @Column(length = 255, nullable = false)
    private int year;
    @Column(length = 255, nullable = false)
    private String director;
    @Column(length = 255, nullable = false)
    private URL poster;
    @Column(length = 255, nullable = false)
    private URL trailer;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;

}
