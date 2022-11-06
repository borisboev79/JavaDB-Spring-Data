package entities.auxiliary;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AutoId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    public AutoId() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
