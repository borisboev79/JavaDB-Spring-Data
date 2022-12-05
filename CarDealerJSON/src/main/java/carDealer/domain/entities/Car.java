package carDealer.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends AutoId{
    @Column
    private String make;

    @Column
    private String model;

    @Column(name = "travelled_distance")
    private Long travelledDistance;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "parts_cars",
    joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
    private Set<Part> parts;

    @OneToOne(mappedBy = "car", targetEntity = Sale.class)
    @Fetch(FetchMode.JOIN)
    private Sale sale;


}
