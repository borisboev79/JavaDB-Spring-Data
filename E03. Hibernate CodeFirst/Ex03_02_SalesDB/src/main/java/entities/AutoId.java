package entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AutoId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    public AutoId(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
