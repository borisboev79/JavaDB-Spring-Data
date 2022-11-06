package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "store_location")
public class StoreLocation extends AutoId{
    @Column(name = "location_name")
    private String locationName;

    @OneToMany(targetEntity = Sale.class, mappedBy = "storeLocation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sale> sales;

    public StoreLocation(){}

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
