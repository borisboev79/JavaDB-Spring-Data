package Ex03_06_FootballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Town extends AutoIncrementId {

    @Column
    private String name;

    @ManyToOne
    private Country country;

    public Town() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
