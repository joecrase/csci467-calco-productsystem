package csci467.calfco.productsystem.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuantityOnHand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "quanityOnHandId")
    @JsonProperty("part")  // parent
    private int partId;
    @JsonProperty("inventory")
    private int inventory;

    public QuantityOnHand() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
