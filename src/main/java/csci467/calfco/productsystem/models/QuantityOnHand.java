package csci467.calfco.productsystem.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "quantity_on_hand")
public class QuantityOnHand extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private int inventory;

    @OneToOne
    private Part part;

    public QuantityOnHand() {
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
