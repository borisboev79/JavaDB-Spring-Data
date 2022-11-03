package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Continent extends AutoIncrementId {

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
