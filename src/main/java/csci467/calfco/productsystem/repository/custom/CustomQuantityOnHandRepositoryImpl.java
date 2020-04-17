package csci467.calfco.productsystem.repository.custom;

import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.models.QuantityOnHand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CustomQuantityOnHandRepositoryImpl implements CustomQuantityOnHandRepository {

    @Override
    public List<QuantityOnHand> initializeQuantityOnHand(List<Part> parts) {
        Random random = new Random();

        List<QuantityOnHand> inventory = new ArrayList<>();


        parts.forEach(part -> {
            QuantityOnHand temp = new QuantityOnHand();
            temp.setPartId(part.getId());
            temp.setInventory(random.nextInt(100));
            inventory.add(temp);
        });

        System.out.println(inventory);

        return inventory;
    }
}
