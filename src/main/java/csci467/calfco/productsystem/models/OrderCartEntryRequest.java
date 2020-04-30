package csci467.calfco.productsystem.models;

public class OrderCartEntryRequest {

    private int partID;
    private int amount;

    public OrderCartEntryRequest() {
    }

    public OrderCartEntryRequest(int partID, int amount) {
        this.partID = partID;
        this.amount = amount;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderCartEntryRequest{" +
                "partID=" + partID +
                ", amount=" + amount +
                '}';
    }
}
