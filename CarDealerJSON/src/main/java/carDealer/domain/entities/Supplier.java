package carDealer.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier extends AutoId{

    @Column
    private String name;

    @Column(name = "is_importer")
    private boolean isImporter;

    @OneToMany(mappedBy = "supplier", targetEntity = Part.class, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Fetch(FetchMode.JOIN)
    private List<Part> parts;
}
