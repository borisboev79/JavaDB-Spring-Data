package entities;

import entities.auxiliary.AutoId;
import jakarta.persistence.*;

@Entity
@Table(name = "continents")
public class Continent extends AutoId {

    @Column
    private String name;

    public Continent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
