package no.experis.assignment3.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franchise_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "franchise")
    private Set<Movie> movies;

    public void updateMoviesToFranchise(List<Integer> movieId) {
        Iterator<Movie> iter = movies.iterator();
        Set<Movie> delete = new HashSet<>();
        while (iter.hasNext()) {
            Movie moviee = iter.next();
            delete.add(moviee);
        }
        movies.removeAll(delete);
        for (int id : movieId) {
            Movie movie = new Movie();
            movie.setId(id);
            movies.add(movie);
        }
    }

    @Override
    public String toString() {
        return "Franchise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
