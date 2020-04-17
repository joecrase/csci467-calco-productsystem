package csci467.calfco.productsystem.bootstrap;

import csci467.calfco.productsystem.models.QuantityOnHand;
import csci467.calfco.productsystem.service.PartService;
import csci467.calfco.productsystem.service.map.QuantityOnHandServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BootStrapData implements CommandLineRunner {
    QuantityOnHandServiceMap quantityOnHandMapService;
    PartService partService;

    public BootStrapData(QuantityOnHandServiceMap quantityOnHandMapService, PartService partService) {
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
            QuantityOnHand quantityOnHand = new QuantityOnHand();
            quantityOnHand.setPart(entry);
            quantityOnHand.setInventory(random.nextInt(100));
            quantityOnHandMapService.save(quantityOnHand);
        });
    }
}
