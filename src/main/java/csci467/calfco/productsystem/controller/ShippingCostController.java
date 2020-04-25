package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.ShippingCost;
import csci467.calfco.productsystem.service.map.ShippingCostServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping("shippingCost")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

        // delete table then recreate
        shippingCostServiceMap.deleteTable();
        toModify.forEach(entry -> {
            System.out.println(entry.toString());
            ShippingCost temp = shippingCostServiceMap.save(entry);
            System.out.println(temp.toString());
        });

        return  new TreeSet<ShippingCost>(shippingCostServiceMap.findAll());
    }

    @PostMapping
    @RequestMapping("/add")
    public @ResponseBody Set<ShippingCost> addShippingCost(@RequestBody Set<ShippingCost> toAdd){

        toAdd.forEach(shippingCost -> {
            System.out.println(shippingCost.toString());
            if (shippingCostServiceMap.findByWeight(shippingCost.getMaxWeight()) == null && shippingCost.getId() == null) { // id is null, create new entry in database
                ShippingCost newShippingCost = new ShippingCost();
                shippingCostServiceMap.delete(shippingCostServiceMap.findByWeight(shippingCost.getMaxWeight()));
                newShippingCost.setPrice(shippingCost.getPrice());
                newShippingCost.setMaxWeight(shippingCost.getMaxWeight());
                shippingCostServiceMap.save(newShippingCost);
            } else if (shippingCost.getId() == null){
                ShippingCost temp = shippingCostServiceMap.findByWeight(shippingCost.getMaxWeight());
                temp.setMaxWeight(shippingCost.getMaxWeight());
                temp.setPrice(shippingCost.getPrice());
                shippingCostServiceMap.save(temp);
            }
        });

        return  new TreeSet<ShippingCost>(shippingCostServiceMap.findAll());
    }


        // for a given weight, returns the shipping price
    @GetMapping
    @RequestMapping("/getCost/{weight}")
    public @ResponseBody float getCost(@PathVariable (value = "weight") float toFind){

        TreeSet<ShippingCost> shippingCostTreeSet = new TreeSet<ShippingCost>(shippingCostServiceMap.findAll());
        ShippingCost previous = shippingCostTreeSet.first();
        float shippingCost = -1;

        for (ShippingCost entry : shippingCostTreeSet) {
            if (entry.getMaxWeight() > toFind){
                shippingCost = previous.getPrice();
            } else {
                previous = entry;
            }
        }
        return shippingCost;
    }

}
