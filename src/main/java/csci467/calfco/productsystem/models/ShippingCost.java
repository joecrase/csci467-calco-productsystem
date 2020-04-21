package csci467.calfco.productsystem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ShippingCost extends BaseEntity implements Comparable<ShippingCost> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private float maxWeight;
    private float price;
    private String error;

    public ShippingCost() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShippingCost that = (ShippingCost) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ShippingCost{" +
                "id=" + id +
                ", maxWeight=" + maxWeight +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(ShippingCost shippingCost) {

        int result = 0;

        if (this.getMaxWeight() < shippingCost.getMaxWeight()){
            result = -1;
        } else if (this.getMaxWeight() > shippingCost.getMaxWeight()){
            result = 1;
        }

        return result;
    }
}
