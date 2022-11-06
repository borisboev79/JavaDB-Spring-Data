package entities;

import entities.auxiliary.AutoId;
import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "teams")
public class Team extends AutoId {

    @Column
    private String name;

    @Column
    private String logo;

    @Column(length = 3)
    private String initials;

    @ManyToOne(optional = false)
    @JoinColumn(name = "primary_kit_color")
    private Color primaryColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "secondary_kit_color")
    private Color secondaryColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "town_id")
    private Town town;

    @Column
    private BigInteger budget;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public BigInteger getBudget() {
        return budget;
    }

    public void setBudget(BigInteger budget) {
        this.budget = budget;
    }
}
