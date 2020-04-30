package csci467.calfco.productsystem.models;

import javax.persistence.*;

@Entity
public class OrderCartEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Part part;
    private int amount;

    public OrderCartEntry() {
    }

    public OrderCartEntry(Part part, int amount) {
        this.part = part;
        this.amount = amount;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
