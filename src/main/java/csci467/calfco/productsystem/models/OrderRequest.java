package csci467.calfco.productsystem.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class OrderRequest {

    @JsonProperty("authorizationNumber")
    private String authorizationNumber;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("priceTotal")
    private float priceTotal;
    @JsonProperty("orderStatus")
    private String orderStatus; // authorized, filling, shipped
    @JsonProperty("datePurchased")
    private String datePurchased; // REQUIRED FORMAT YYYY/MM/DD

    @OneToMany
    private Set<OrderCartEntryRequest> cart = new HashSet<>();

    public OrderRequest() {
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public void setAuthorizationNumber(String authorizationNumber) {
        this.authorizationNumber = authorizationNumber;
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(String datePurchased) {
        this.datePurchased = datePurchased;
    }

    public Set<OrderCartEntryRequest> getCart() {
        return cart;
    }

    public void setCart(Set<OrderCartEntryRequest> cart) {
        this.cart = cart;
    }
}
