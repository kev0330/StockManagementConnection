package cput.ac.za.domain.system;

import javax.persistence.*;

@Entity
@Table(name="TBL_STOCK")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private String price;

    @Column(name="qty")
    private String qty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Stock [id = " + id + ", Description = " + description +
                ", Price = " + price + ", Quantity = " + qty   + "]";
    }
}
