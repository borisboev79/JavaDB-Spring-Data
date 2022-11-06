package entities;

import entities.auxiliary.AutoId;
import jakarta.persistence.*;


@Entity
@Table(name = "rounds")
public class Round extends AutoId {
  @Column
    private String name;

  public Round(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
