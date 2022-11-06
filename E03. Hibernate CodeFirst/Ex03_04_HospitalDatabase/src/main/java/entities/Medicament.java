package entities;

import auxiliary.AutoId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Medicament extends AutoId {
    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "medicaments", targetEntity = Diagnose.class)
    private Set<Diagnose> diagnoses;

    public Medicament(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
