package carDealer.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sale extends AutoId{
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @Fetch(FetchMode.JOIN)
    private Car car;

    @Column
    private BigDecimal discount;

}
