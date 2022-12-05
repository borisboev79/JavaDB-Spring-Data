package carDealer.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends AutoId {

    @Column
    private String name;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "is_young_driver")
    private boolean isYoungDriver;

    @OneToMany(targetEntity = Sale.class, mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Fetch(FetchMode.JOIN)
    private Set<Sale> sales;

}
