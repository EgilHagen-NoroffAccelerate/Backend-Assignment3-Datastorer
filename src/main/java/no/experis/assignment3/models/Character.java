package no.experis.assignment3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50)
    private String alias;
    @Column(length = 10)
    private String gender;
    @Column(length = 100)
    private String photo;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "characters")
    private Set<Movie> movies;

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", gender='" + gender + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
