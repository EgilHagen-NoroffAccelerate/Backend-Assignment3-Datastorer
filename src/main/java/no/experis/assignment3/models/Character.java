package no.experis.assignment3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.Set;

@Entity
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String alias;

    @Column(length = 255, nullable = false)
    private String gender;

    @Column(length = 255, nullable = false)
    private URL photo;

    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;

}
