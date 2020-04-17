package csci467.calfco.productsystem.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("authorizationNumber")
    private String authorizationNumber;
    @JsonProperty("trackingNumber")
    private String trackingNumber;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("priceTotal")
    private float priceTotal;
    @JsonProperty("isAuthorized")
    private boolean isAuthorized;
    @JsonProperty("isShipped")
    private boolean isShipped;

    @OneToMany
    private Set<OrderInfo> cart = new HashSet<>();

    @ManyToOne
    private Customer customer;

    public Order() {
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public void setAuthorizationNumber(String authorizationNumber) {
        this.authorizationNumber = authorizationNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(float priceTotal) {
        this.priceTotal = priceTotal;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    public boolean isShipped() {
        return isShipped;
    }

    public void setShipped(boolean shipped) {
        isShipped = shipped;
    }

    public Set<OrderInfo> getCart() {
        return cart;
    }

    public void setCart(Set<OrderInfo> cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
