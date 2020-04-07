package csci467.calfco.productsystem.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Part {

    @Id
    private int id;

    private String description;
    private float price;
    private float weight;
    private String pictureURL;

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
}
