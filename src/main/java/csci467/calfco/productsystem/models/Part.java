package csci467.calfco.productsystem.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Part {

    @Id
    @JsonProperty("number")
    private int id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private float price;
    @JsonProperty("weight")
    private float weight;
    @JsonProperty("pictureURL")
    private String pictureURL;

    //@OneToOne(mappedBy = "quantityOnHandId")
    private int quantityOnHandId; // child

    public Part() {
    }

    public Part(int id, String description, float price, float weight, String pictureURL) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.pictureURL = pictureURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public int getQuantityOnHandId() {
        return quantityOnHandId;
    }

    public void setQuantityOnHandId(int quantityOnHandId) {
        this.quantityOnHandId = quantityOnHandId;
    }
}
