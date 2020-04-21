package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.Inventory;
import csci467.calfco.productsystem.models.InventoryChangeRequest;
import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.service.map.InventoryServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping(path = "/inventory")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InventoryController {

    InventoryServiceMap inventoryServiceMap;

    public InventoryController(InventoryServiceMap inventoryServiceMap) {
        this.inventoryServiceMap = inventoryServiceMap;
    }



    @GetMapping(path = {"", "/", "index"})
    public List<Part> initializeQuantityOnHand(){

        return null;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Inventory> getAll(){

        return new TreeSet<Inventory>(inventoryServiceMap.findAll());
    }

    // Accepts array of json objects:
    /*
    [
        {
            "partId": 1234,
            "toChangeAmount": 1234
        },
        ...
    ]
     */
    // Need to add some sort of response for these two to indicate success
    @PostMapping(path = "/increment")
    public @ResponseBody Set<Inventory> addToInventory(@RequestBody Set<InventoryChangeRequest> toChange) {

        toChange.forEach(entry -> {
            Inventory temp = inventoryServiceMap.findByPartId(entry.getPartId());
            temp.setInventory(temp.getInventory() + entry.getToChangeAmount());
            inventoryServiceMap.save(temp);
        });

        return new TreeSet<Inventory>(inventoryServiceMap.findAll());

    }

    // Accepts array of json objects:
    /*
    [
        {
            "partId": 1234,
            "toChangeAmount": 1234
        },
        ...

    ]
     */
    // Need to add some sort of response for these two to indicate succes
    @PostMapping(path = "/decrement")
    public @ResponseBody Set<Inventory> subtractFromInventory(@RequestBody Set<InventoryChangeRequest> toChange){

        toChange.forEach(entry -> {
            Inventory temp = inventoryServiceMap.findByPartId(entry.getPartId());
            temp.setInventory(temp.getInventory() - entry.getToChangeAmount());
            inventoryServiceMap.save(temp);
        });


        return new TreeSet<Inventory>(inventoryServiceMap.findAll());
    }

    @GetMapping(path = "/{partId}")
    public @ResponseBody Inventory getInventoryById(@PathVariable(value = "partId") int partId){
        return inventoryServiceMap.findByPartId(partId);
    }

}
