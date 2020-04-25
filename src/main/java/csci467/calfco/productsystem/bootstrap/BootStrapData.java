package csci467.calfco.productsystem.bootstrap;

import csci467.calfco.productsystem.models.*;
import csci467.calfco.productsystem.service.PartService;
import csci467.calfco.productsystem.service.map.CustomerServiceMap;
import csci467.calfco.productsystem.service.map.InventoryServiceMap;
import csci467.calfco.productsystem.service.map.OrderServiceMap;
import csci467.calfco.productsystem.service.map.ShippingCostServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class BootStrapData implements CommandLineRunner {
    InventoryServiceMap inventoryServiceMap;
    PartService partService;
    CustomerServiceMap customerServiceMap;
    OrderServiceMap orderServiceMap;
    ShippingCostServiceMap shippingCostServiceMap;

    public BootStrapData(InventoryServiceMap inventoryServiceMap, PartService partService, CustomerServiceMap customerServiceMap,
                         OrderServiceMap orderServiceMap, ShippingCostServiceMap shippingCostServiceMap) {
        this.inventoryServiceMap = inventoryServiceMap;
        this.partService = partService;
        this.customerServiceMap = customerServiceMap;
        this.orderServiceMap = orderServiceMap;
        this.shippingCostServiceMap = shippingCostServiceMap;
    }

    @Override
    public void run(String... args) throws Exception {

        if(inventoryServiceMap.findAll().size() == 0) {
            initializeData();
        }


    }

    private void initializeData() {
        Random random = new Random();

        // Create the inventory
        partService.getAllParts().forEach(entry ->{
            Inventory inventory = new Inventory();
            inventory.setPart(entry);
            inventory.setInventory(random.nextInt(100));
            inventoryServiceMap.save(inventory);
        });

        // Create the customers
        Customer JCrase = createCustomer("Joseph", "Crase", "312 South Fifth Street", "joecrase@gmail.com", "somepassword");
        Customer MFreund = createCustomer("Molly", "Freund", "Middle of Nowhere", "smurfLord6969@gmail.com", "anotherpassword");
        Customer AAdams = createCustomer("Adelaide", "Adams", "Somewhere Warm", "acoolemail@gmail.com", "goodpassword");
        Customer RLlama = createCustomer("Ryan", "Llamas", "A bit North", "sexylamas6969@gmail.com", "legitpassword");

        /* Setting Shipping Costs */
        for(int i = 0; i <= 100; i = i + 5){
            ShippingCost tempShippingCost = new ShippingCost();
            tempShippingCost.setMaxWeight(i);
            tempShippingCost.setPrice((i / 5) * 3);
            shippingCostServiceMap.save(tempShippingCost);
        }

        // Create the orders
        CreateTheOrders(JCrase, MFreund, AAdams, RLlama);

    }

    private void CreateTheOrders(Customer JCrase, Customer MFreund, Customer AAdams, Customer RLlama) {
        createOrder(JCrase);
        createOrder(JCrase);
        createOrder(JCrase);
        createOrder(JCrase);
        createOrder(JCrase);
        createOrder(JCrase);
        createOrder(JCrase);

        createOrder(MFreund);
        createOrder(MFreund);
        createOrder(MFreund);
        createOrder(MFreund);
        createOrder(MFreund);
        createOrder(MFreund);
        createOrder(MFreund);

        createOrder(AAdams);
        createOrder(AAdams);
        createOrder(AAdams);
        createOrder(AAdams);
        createOrder(AAdams);
        createOrder(AAdams);
        createOrder(AAdams);

        createOrder(RLlama);
        createOrder(RLlama);
        createOrder(RLlama);
        createOrder(RLlama);
        createOrder(RLlama);
        createOrder(RLlama);
        createOrder(RLlama);
    }

    private Customer createCustomer(String firstName, String lastName, String address,
                                    String email, String password) {
        Customer temp = new Customer();
        temp.setFirstName(firstName);
        temp.setLastName(lastName);
        temp.setAddress(address);
        temp.setEmail(email);
        temp.setPassword(password);

        return customerServiceMap.save(temp);
    }

    private void createOrder(Customer customer) {
        Order tempOrder = new Order();
        // Set authorization number
        tempOrder.setAuthorizationNumber(getAlphaNumericString(10));
        // Set order status
        tempOrder.setOrderStatus(setOrderStatus());
        // Set tracking number based on order status
        if (tempOrder.getOrderStatus().equals("shipped")){
            tempOrder.setTrackingNumber(getAlphaNumericString(10));
        } else {
            tempOrder.setTrackingNumber("");
        }
        // Create cart
        tempOrder.getCart().addAll(setCart());
        // Derive total price and weight from cart
        float[] weightAndPrice = deriveWeightAndPrice(tempOrder.getCart());
        tempOrder.setWeight(weightAndPrice[0]);
        tempOrder.setPriceTotal(weightAndPrice[1]);
        // set date
        tempOrder.setDatePurchased(getRandomDate());
        // set customer
        tempOrder.setCustomer(customer);
        // save in map
        orderServiceMap.save(tempOrder);
    }

    private String getRandomDate(){
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate.toString();
    }

    private float[] deriveWeightAndPrice(Set<OrderCartEntry> cart) {


        float totalWeight = 0f;
        float totalPrice = 0f;

        for (OrderCartEntry cartEntry : cart) {
            totalWeight += cartEntry.getPart().getWeight() * cartEntry.getAmount();
            totalPrice += cartEntry.getPart().getPrice() * cartEntry.getAmount();
        }

        totalPrice += shippingCostServiceMap.getCostByWeight(totalWeight);


        BigDecimal bdTotalWeight = new BigDecimal(Float.toString(totalWeight));
        bdTotalWeight = bdTotalWeight.setScale(2, RoundingMode.HALF_UP);
        BigDecimal bdTotalPrice = new BigDecimal(Float.toString(totalPrice));
        bdTotalPrice = bdTotalPrice.setScale(2, RoundingMode.HALF_UP);

        float[] result = {bdTotalWeight.floatValue(), bdTotalPrice.floatValue()};

        return result;
    }

    // function to generate a random string of length n
    public String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public int getRandomInt(int n){
        Random random = new Random();
        return random.nextInt(n);
    }

    public String setOrderStatus(){
        Random random = new Random();
        String orderStatus;
        switch (random.nextInt(3)){
            case 0:
                orderStatus = "authorized";
                break;
            case 1:
                orderStatus = "filling";
                break;
            case 2:
                orderStatus = "shipped";
                break;
            default:
                orderStatus = "error";
                break;
        }
        return orderStatus;
    }

    public Set<OrderCartEntry> setCart(){
        Set<OrderCartEntry> totalCart = new HashSet<>();

        Random random = new Random();
        int numberInCart = random.nextInt(10);

        for(int i = 0; i <= numberInCart ; i++){
            try{
                // try to get a part
                OrderCartEntry temp = new OrderCartEntry(partService.getPartById(random.nextInt(149)), random.nextInt(10) + 1);
                if (temp.getPart() != null)
                    totalCart.add(temp);
            }catch (Error e){

            }
        }

        return totalCart;
    }
}
