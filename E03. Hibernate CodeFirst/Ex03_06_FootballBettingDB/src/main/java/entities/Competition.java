package entities;

import entities.auxiliary.AutoId;
import jakarta.persistence.*;

@Entity
@Table(name = "competitions")
public class Competition extends AutoId {
    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private CompetitionType competitionType;

    public Competition() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }
}
