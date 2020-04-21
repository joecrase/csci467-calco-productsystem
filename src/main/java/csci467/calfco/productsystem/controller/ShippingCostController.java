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

    // Modifies existing weight bracket to a different weight/price
    @PostMapping
    @RequestMapping("/modify")
    public @ResponseBody
    Set<ShippingCost> modifyShippingCost(@RequestBody Set<ShippingCost> toModify){

        toModify.forEach(shippingCost -> {
            if (shippingCostServiceMap.findByWeight(shippingCost.getMaxWeight()).getId() == null || shippingCostServiceMap.findByWeight(shippingCost.getMaxWeight()).getId() == shippingCost.getId() ){
                ShippingCost newShippingCost = shippingCostServiceMap.findById(shippingCost.getId());
                newShippingCost.setPrice(shippingCost.getPrice());
                newShippingCost.setMaxWeight(shippingCost.getMaxWeight());
                shippingCostServiceMap.save(newShippingCost);
            } else {
                shippingCostServiceMap.delete(shippingCostServiceMap.findByWeight(shippingCost.getMaxWeight()));
                ShippingCost newShippingCost = shippingCostServiceMap.findById(shippingCost.getId());
                newShippingCost.setPrice(shippingCost.getPrice());
                newShippingCost.setMaxWeight(shippingCost.getMaxWeight());
                shippingCostServiceMap.save(newShippingCost);
            }
        });

        return  new TreeSet<ShippingCost>(shippingCostServiceMap.findAll());
    }





}
