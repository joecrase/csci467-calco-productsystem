package csci467.calfco.productsystem.bootstrap;

import csci467.calfco.productsystem.models.Customer;
import csci467.calfco.productsystem.models.Inventory;
import csci467.calfco.productsystem.models.Order;
import csci467.calfco.productsystem.models.OrderCartEntry;
import csci467.calfco.productsystem.service.PartService;
import csci467.calfco.productsystem.service.map.CustomerServiceMap;
import csci467.calfco.productsystem.service.map.InventoryServiceMap;
import csci467.calfco.productsystem.service.map.OrderServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BootStrapData implements CommandLineRunner {
    InventoryServiceMap quantityOnHandMapService;
    PartService partService;
    CustomerServiceMap customerServiceMap;
    OrderServiceMap orderServiceMap;

    public BootStrapData(InventoryServiceMap quantityOnHandMapService, PartService partService, CustomerServiceMap customerServiceMap, OrderServiceMap orderServiceMap) {
        this.quantityOnHandMapService = quantityOnHandMapService;
        this.partService = partService;
        this.customerServiceMap = customerServiceMap;
        this.orderServiceMap = orderServiceMap;
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

        Customer temp = new Customer();
        temp.setFirstName("Joseph");
        temp.setLastName("Crase");
        temp.setAddress("312 South Fifth Street");
        temp.setEmail("joecrase@gmail.com");
        temp.setPassword("somepassword");

        customerServiceMap.save(temp);

        Customer temp2 = new Customer();
        temp2.setFirstName("Molly");
        temp2.setLastName("Freund");
        temp2.setAddress("Middle of Nowhere");
        temp2.setEmail("smurfLord6969@gmail.com");
        temp2.setPassword("anotherpassword");

        customerServiceMap.save(temp2);

        customerServiceMap.findAll().forEach(consumer -> {
            System.out.println(consumer.toString());
        });

        Order tempOrder = new Order();
        tempOrder.setAuthorizationNumber("XXXXXXXX");
        tempOrder.setTrackingNumber("YYYYYYY");
        tempOrder.setWeight(100);
        tempOrder.setPriceTotal(12.31f);
        tempOrder.setOrderStatus("authorized");
        tempOrder.setDatePurchased("4/17/2020");
        tempOrder.setCustomer(temp);
        OrderCartEntry tempCartEntry = new OrderCartEntry();
        tempCartEntry.setPartId(1);
        tempCartEntry.setAmount(10);
        tempOrder.getCart().add(tempCartEntry);
        OrderCartEntry tempCartEntry2 = new OrderCartEntry();
        tempCartEntry2.setPartId(2);
        tempCartEntry2.setAmount(12);
        tempOrder.getCart().add(tempCartEntry2);
        orderServiceMap.save(tempOrder);



    }
}
