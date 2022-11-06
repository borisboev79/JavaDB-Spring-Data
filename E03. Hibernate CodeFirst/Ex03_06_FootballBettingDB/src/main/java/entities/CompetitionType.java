package entities;

import entities.auxiliary.AutoId;
import jakarta.persistence.*;

@Entity
@Table(name = "competition_type")
public class CompetitionType extends AutoId {
    @Column
    private String type;

    public CompetitionType() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}