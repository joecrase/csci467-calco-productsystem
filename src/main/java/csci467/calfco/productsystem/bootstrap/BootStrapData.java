package csci467.calfco.productsystem.bootstrap;

import csci467.calfco.productsystem.models.Inventory;
import csci467.calfco.productsystem.service.PartService;
import csci467.calfco.productsystem.service.map.InventoryServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BootStrapData implements CommandLineRunner {
    InventoryServiceMap quantityOnHandMapService;
    PartService partService;

    public BootStrapData(InventoryServiceMap quantityOnHandMapService, PartService partService) {
        this.quantityOnHandMapService = quantityOnHandMapService;
        this.partService = partService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(quantityOnHandMapService.findAll().size() == 0) {
            initializeData();
        }


    }

    private void initializeData() {
        Random random = new Random();

        partService.getAllParts().forEach(entry ->{
            Inventory inventory = new Inventory();
            inventory.setPart(entry);
            inventory.setInventory(random.nextInt(100));
            quantityOnHandMapService.save(inventory);
        });
    }
}
