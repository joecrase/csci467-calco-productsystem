package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.Order;
import csci467.calfco.productsystem.models.OrderCartEntry;
import csci467.calfco.productsystem.models.OrderRequest;
import csci467.calfco.productsystem.service.PartService;
import csci467.calfco.productsystem.service.map.CustomerServiceMap;
import csci467.calfco.productsystem.service.map.OrderServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

    // TODO : implement getting an order by id
    // TODO : implement getting a set of orders by shipped
    // TODO : implement setting the shipped property (for Filling Orders)
    // TODO : implement returning invoice information


    OrderServiceMap orderServiceMap;
    CustomerServiceMap customerServiceMap;
    PartService partService;

    public OrderController(OrderServiceMap orderServiceMap, CustomerServiceMap customerServiceMap, PartService partService) {
        this.orderServiceMap = orderServiceMap;
        this.customerServiceMap = customerServiceMap;
        this.partService = partService;
    }

    @GetMapping({"", "/", "index"})
    public @ResponseBody String test(){
        return "You have hit the order controller";
    }

    @GetMapping("/all")
    public @ResponseBody Set<Order> getAll(){
        return orderServiceMap.findAll();
    }

    @GetMapping("/{orderId}")
    public @ResponseBody Order getOrderById(@PathVariable(value = "orderId") Long orderId){
        return orderServiceMap.findById(orderId);
    }

    // Request Body
    /*
    {
        "cart": [
            {
                "partId": 123,
                "amount": 123
            },
            ...
        ]
        "authorizationNumber": "abc",
        "weight": 123,
        "priceTotal": 1.0,
        "orderStatus" "abc",
        "datePurchased": "1/23/4567"
    }
     */
    // Response Body
    /*
         {
        "cart": [
            {
                "part": {
                    "number": 123,
                    "description": "abc",
                    "price": 123.123,
                    "weight": 123.123,
                    "pictureURL": "abc"
                },
                "amount": 123
            },
            ...
        ],
        "customer": {
            "id": 1,
            "firstName": "abc",
            "lastName": "abc",
            "email": "abc",
            "password": "abc",
            "address": "abc"
        },
        "authorizationNumber": "abc",
         "trackingNumber": "abc",
        "weight": 123,
        "priceTotal": 1.0,
        "orderStatus": "abc",
        "datePurchased": "1/23/4567"
    }
     */
    @PostMapping ("/{customerId}") // Id of the customer whom placed the order
    public @ResponseBody Order createOrder(@RequestBody OrderRequest orderRequest, @PathVariable(value = "customerId") Long customerId){

        Order order = new Order();
        order.setAuthorizationNumber(orderRequest.getAuthorizationNumber());
        order.setTrackingNumber("");
        order.setWeight(orderRequest.getWeight());
        order.setPriceTotal(orderRequest.getPriceTotal());
        order.setOrderStatus(orderRequest.getOrderStatus());
        order.setDatePurchased(orderRequest.getDatePurchased());
        // add cart stuff
        orderRequest.getCart().forEach(entry -> order.getCart().add(new OrderCartEntry(partService.getPartById(entry.getPartID()), entry.getAmount())));
        // add the customer
        order.setCustomer(customerServiceMap.findById(customerId));

        return orderServiceMap.save(order);

    }

    @PostMapping ("/updateStatus/{orderId}/{orderStatus}")
    public @ResponseBody String updateOrderStatus(@PathVariable(value = "orderId") Long orderId, @PathVariable(value = "orderStatus") String orderStatus){

        Order temp = orderServiceMap.findById(orderId);
        if (temp == null) return "Could not find order with given id";
        temp.setOrderStatus(orderStatus);
        orderServiceMap.save(temp);

        return "Order status for order " + orderId + " set to " + orderStatus;
    }


}
