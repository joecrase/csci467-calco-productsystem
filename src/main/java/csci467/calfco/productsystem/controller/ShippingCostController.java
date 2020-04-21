package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.ShippingCost;
import csci467.calfco.productsystem.service.map.ShippingCostServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping("shippingCost")
public class ShippingCostController {

    ShippingCostServiceMap shippingCostServiceMap;

    public ShippingCostController(ShippingCostServiceMap shippingCostServiceMap) {
        this.shippingCostServiceMap = shippingCostServiceMap;
    }

    @GetMapping
    @RequestMapping("/all")
    public @ResponseBody Set<ShippingCost> getAllShippingCost(){

       return new TreeSet<ShippingCost>(shippingCostServiceMap.findAll());
    }

    // Modifies the weight bracket to a different weight/price
    // Can give a specific id -> modifies that entry
    // Can give no id -> creates new entry and inserts
    @PostMapping
    @RequestMapping("/modify")
    public @ResponseBody Set<ShippingCost> modifyShippingCost(@RequestBody Set<ShippingCost> toModify){

        toModify.forEach(shippingCost -> {
            if (shippingCost.getId() != null && shippingCostServiceMap.findByWeight(shippingCost.getMaxWeight()).getId() == shippingCost.getId()){
                // id was provided, and it is an object in the database with the same id
                ShippingCost newShippingCost = shippingCostServiceMap.findById(shippingCost.getId());
                newShippingCost.setPrice(shippingCost.getPrice());
                newShippingCost.setMaxWeight(shippingCost.getMaxWeight());
                shippingCostServiceMap.save(newShippingCost);
            } else if (shippingCostServiceMap.findById(shippingCost.getId()) != null) { // if an id was provided, and is in the database
                ShippingCost newShippingCost = shippingCostServiceMap.findById(shippingCost.getId());
                shippingCostServiceMap.delete(shippingCostServiceMap.findByWeight(shippingCost.getMaxWeight()));
                newShippingCost.setPrice(shippingCost.getPrice());
                newShippingCost.setMaxWeight(shippingCost.getMaxWeight());
                shippingCostServiceMap.save(newShippingCost);
            } else { // id is null, create new entry in database
                ShippingCost newShippingCost = new ShippingCost();
                shippingCostServiceMap.delete(shippingCostServiceMap.findByWeight(shippingCost.getMaxWeight()));
                newShippingCost.setPrice(shippingCost.getPrice());
                newShippingCost.setMaxWeight(shippingCost.getMaxWeight());
                shippingCostServiceMap.save(newShippingCost);
            }
        });

        return  new TreeSet<ShippingCost>(shippingCostServiceMap.findAll());
    }

}
