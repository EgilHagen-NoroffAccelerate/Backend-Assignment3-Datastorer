package no.experis.assignment3.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A class which represents what a Movie contains.
 */
@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 50)
    private String genre;
    @Column(name = "release_year", nullable = false)
    private String releaseYear;
    @Column(length = 50)
    private String director;
    @Column(length = 100)
    private String poster;
    @Column(length = 100)
    private String trailer;
    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;
    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @JsonGetter("franchise")
    public Integer jsonGetFranchise() {
        if (franchise != null)
            return franchise.getId();
        return null;
    }

    @JsonGetter("characters")
    public List<Integer> jsonGetCharacters() {
        if (characters != null)
            return characters.stream().map(s -> s.getId()).collect(Collectors.toList());
        return null;
    }

    public void updateCharactersToMovie(List<Integer> characterId) {
        Iterator<Character> iter = characters.iterator();
        Set<Character> delete = new HashSet<>();
        while (iter.hasNext()) {
            Character chara = iter.next();
            delete.add(chara);
        }
        characters.removeAll(delete);
        for (int id : characterId) {
            Character chars = new Character();
            chars.setId(id);
            characters.add(chars);
        }
    }
}
