package no.experis.assignment3.models;

import jakarta.persistence.*;

import java.net.URL;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "char_id")
    private int id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "alias", length = 255, nullable = false)
    private String alias;

    @Column(name = "gender", length = 255, nullable = false)
    private String gender;

    @Column(name = "photo", length = 255, nullable = false)
    private URL photo;

    public Character(int id, String name, String alias, String gender, URL photo) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.gender = gender;
        this.photo = photo;
    }

    public Character() {

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
