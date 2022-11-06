package entities;

import entities.auxiliary.AutoId;
import jakarta.persistence.*;

@Entity
@Table(name = "towns")
public class Town extends AutoId {

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
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
