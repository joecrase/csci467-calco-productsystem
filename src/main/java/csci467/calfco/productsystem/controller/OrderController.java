package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.Order;
import csci467.calfco.productsystem.models.OrderCartEntry;
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

    public OrderController(OrderServiceMap orderServiceMap, CustomerServiceMap customerServiceMap) {
        this.orderServiceMap = orderServiceMap;
        this.customerServiceMap = customerServiceMap;
    }

    @GetMapping({"", "/", "index"})
    public @ResponseBody String test(){
        return "You have hit the order controller";
    }

    @GetMapping("/all")
    public @ResponseBody Set<Order> getAll(){
        return orderServiceMap.findAll();
    }

    /* Request Body
    {
        "cart": [
            {
                "partId": 123,
                "amount": 123
            },
            ...
        ]
        "authorized": false,
        "shipped": false,
        "authorizationNumber": "abc",
        "trackingNumber": "abc",
        "weight": 123,
        "priceTotal": 1.0,
        "isAuthorized": false,
        "isShipped": false
    }
     */
    /* Response Body
         {
        "cart": [
            {
                "partId": 123,
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
        "authorized": false,
        "shipped": false,
        "authorizationNumber": "abc",
        "trackingNumber": "abc",
        "weight": 123,
        "priceTotal": 1.0,
        "isAuthorized": false,
        "isShipped": false
    }
     */
    @PostMapping ("/{customerId}")
    public @ResponseBody Order createOrder(@RequestBody Order order, @PathVariable(value = "customerId") Long customerId){

        order.setCustomer(customerServiceMap.findById(customerId));

        return orderServiceMap.save(order);

    }


    @PostMapping ("/updateOrder/cart/{id}")
    public @ResponseBody Order updateOrderCart(@RequestBody Set<OrderCartEntry> cartUpdate, @PathVariable(value = "orderId") Long orderId){

        Order temp = new Order();

        return null;
    }
}
