package Ex03_06_FootballBettingDatabase.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AutoIncrementId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    public AutoIncrementId() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
