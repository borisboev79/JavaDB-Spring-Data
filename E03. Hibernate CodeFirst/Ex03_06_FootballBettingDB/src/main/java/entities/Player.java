package entities;

import entities.auxiliary.AutoId;
import jakarta.persistence.*;


@Entity
@Table(name = "players")
public class Player extends AutoId {
    @Column
    private String name;

    @Column(name = "squad_number")
    private int squadNumber;

    @ManyToOne
    private Team team;


    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name = "is_injured")
    private boolean isCurrentlyInjured;

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isCurrentlyInjured() {
        return isCurrentlyInjured;
    }

    public void setCurrentlyInjured(boolean currentlyInjured) {
        isCurrentlyInjured = currentlyInjured;
    }
}
