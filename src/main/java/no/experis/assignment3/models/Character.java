package no.experis.assignment3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.net.URL;

@Entity
public class Character {
    @Id
    private int id;
    private String name;
    private String alias;
    private String gender;
    private URL photo;

    public Character() {
    }

    public Character(int id, String name, String alias, String gender, URL photo) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.gender = gender;
        this.photo = photo;
    }

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public URL getPhoto() {
        return photo;
    }

    public void setPhoto(URL photo) {
        this.photo = photo;
    }
}
