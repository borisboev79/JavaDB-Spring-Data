package entities;

import jakarta.persistence.*;

import javax.swing.text.Position;

@Entity
public class Player extends AutoIncrementId{
    @Column
    private String name;

    @Column
    private int squadNumber;

    @Column
    @ManyToOne
    private Team team;


    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

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
}
