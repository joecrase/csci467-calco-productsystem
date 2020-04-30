package csci467.calfco.productsystem.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity implements Comparable<Inventory> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private int inventory;

    @OneToOne
    private Part part;

    public Inventory() {
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

    @Override
    public int compareTo(Inventory inventory) {

        int result = 0;

        if (this.getPart().getId() < inventory.getPart().getId()){
            result = -1;
        } else if (this.getPart().getId() > inventory.getPart().getId()){
            result = 1;
        }

        return result;
    }
}
