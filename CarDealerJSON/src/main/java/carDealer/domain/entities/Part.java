package carDealer.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parts")
public class Part extends AutoId{

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private Integer quantity;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    @ManyToMany (mappedBy = "parts", targetEntity = Car.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Fetch(FetchMode.JOIN)
    private Set<Car> cars;
}
