package csci467.calfco.productsystem.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "quantity_on_hand")
public class QuantityOnHand extends BaseEntity {

    @Id
    private int partId;

    private int inventory;

    public QuantityOnHand() {
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
