package no.experis.assignment3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movies {
    @Id
    private int id;

    public Movies() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
