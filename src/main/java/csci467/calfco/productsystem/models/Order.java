package csci467.calfco.productsystem.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Order extends BaseEntity {

    // TODO: Change order status to a String value

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("authorizationNumber")
    private String authorizationNumber;
    @JsonProperty("trackingNumber")
    private String trackingNumber;
    @JsonProperty("weight")
    private float weight;
    @JsonProperty("priceTotal")
    private float priceTotal;
    @JsonProperty("orderStatus")
    private String orderStatus; // authorized, filling, shipped
    @JsonProperty("datePurchased")
    private String datePurchased; // REQUIRED FORMAT YYYY/MM/DD

    @OneToMany
    private Set<OrderCartEntry> cart = new HashSet<>();

    @ManyToOne
    private Customer customer;

    public Order() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(String datePurchased) {
        this.datePurchased = datePurchased;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(float priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<OrderCartEntry> getCart() {
        return cart;
    }

    public void setCart(Set<OrderCartEntry> cart) {
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", authorizationNumber='" + authorizationNumber + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", weight=" + weight +
                ", priceTotal=" + priceTotal +
                ", orderStatus='" + orderStatus + '\'' +
                ", datePurchased='" + datePurchased + '\'' +
                ", cart=" + cart +
                ", customer=" + customer +
                '}';
    }
}
