package csci467.calfco.productsystem.repository.custom;

import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.models.QuantityOnHand;

import java.util.List;


public interface CustomQuantityOnHandRepository {
    List<QuantityOnHand> initializeQuantityOnHand(List<Part> parts);
}
