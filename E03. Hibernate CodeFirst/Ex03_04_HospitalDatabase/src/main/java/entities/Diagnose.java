package entities;

import auxiliary.AutoId;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Diagnose extends AutoId {
    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String comment;

    @OneToMany(mappedBy = "diagnose", targetEntity = Visitation.class)
    private Set<Visitation> visitations;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "diagnose_medicaments",
            joinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"))
    private Set<Medicament> medicaments;

    public Diagnose(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
}
