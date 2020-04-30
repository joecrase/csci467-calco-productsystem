package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.Customer;
import csci467.calfco.productsystem.service.map.CustomerServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    CustomerServiceMap customerServiceMap;

    public CustomerController(CustomerServiceMap customerServiceMap) {
        this.customerServiceMap = customerServiceMap;
    }

    @GetMapping({"", "/", "index"})
    public @ResponseBody String test(){
        return "You have hit the customer controller";
    }

    @GetMapping("/all")
    public @ResponseBody Set<Customer> getAll(){
        return customerServiceMap.findAll();
    }

}
