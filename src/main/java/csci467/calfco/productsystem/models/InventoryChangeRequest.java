package csci467.calfco.productsystem.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryChangeRequest {

    @JsonProperty("partId")
    private int partId;

    @JsonProperty("toChangeAmount")
    private int toChangeAmount;

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public int getToChangeAmount() {
        return toChangeAmount;
    }

    public void setToChangeAmount(int toChangeAmount) {
        this.toChangeAmount = toChangeAmount;
    }
}
