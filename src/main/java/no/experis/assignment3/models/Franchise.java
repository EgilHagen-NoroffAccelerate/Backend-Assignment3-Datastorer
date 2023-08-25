package no.experis.assignment3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Franchise {

    @Id
    private int id;

    private String name;

    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
