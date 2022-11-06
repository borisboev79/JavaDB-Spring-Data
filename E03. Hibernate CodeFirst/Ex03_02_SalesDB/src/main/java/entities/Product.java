package entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends AutoId{
    @Column
    private String name;

    @Column
    private int quantity;

    @Column
    private BigDecimal price;

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    @OneToMany(targetEntity = Sale.class, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sale> sales;

    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
