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
        "authorizationNumber": "abc",
        "trackingNumber": "abc",
        "weight": 123,
        "priceTotal": 1.0,
        "orderStatus" "abc"
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
        "authorizationNumber": "abc",
        "trackingNumber": "abc",
        "weight": 123,
        "priceTotal": 1.0,
        "orderStatus": "abc"
    }
     */
    @PostMapping ("/{customerId}")
    public @ResponseBody Order createOrder(@RequestBody Order order, @PathVariable(value = "customerId") Long customerId){

        order.setCustomer(customerServiceMap.findById(customerId));

        return orderServiceMap.save(order);

    }


    @PostMapping ("/updateOrder/cart/{orderId}")
    public @ResponseBody Order updateOrderCart(@RequestBody Set<OrderCartEntry> cartUpdate, @PathVariable(value = "orderId") Long orderId){

        Order temp = new Order();

        return null;
    }

    @PostMapping ("/updateStatus/{orderId}/{orderStatus}")
    public @ResponseBody String updateOrderStatus(@PathVariable(value = "orderId") Long orderId, @PathVariable(value = "orderStatus") String orderStatus){

        Order temp = new Order();
        temp = orderServiceMap.findById(orderId);
        if (temp == null){
            return "Could not find order with given id";
        }
        temp.setOrderStatus(orderStatus);
        orderServiceMap.save(temp);

        return "Order status for order " + orderId + " set to " + orderStatus;
    }

    @GetMapping("/{orderId}")
    public @ResponseBody Order getOrderById(@PathVariable(value = "orderId") Long orderId){
        Order temp = new Order();
        temp = orderServiceMap.findById(orderId);
        if (temp == null){
            return null;
        }
        return temp;
    }
}
