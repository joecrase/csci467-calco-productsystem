package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.Inventory;
import csci467.calfco.productsystem.models.InventoryChangeRequest;
import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.service.map.InventoryServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(path = "/inventory")
public class InventoryController {

    InventoryServiceMap inventoryServiceMap;

    public InventoryController(InventoryServiceMap inventoryServiceMap) {
        this.inventoryServiceMap = inventoryServiceMap;
    }

    // TODO: Implement incrementing and decrementing inventory via two api calls (might be sent as a list)
    // TODO: Add call to get inventory amount for a specific part

    @GetMapping(path = {"", "/", "index"})
    public List<Part> initializeQuantityOnHand(){

        return null;
    }

    // Might change QuantityOnHand model to store the entirety of the parts information
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Inventory> getAll(){

        return inventoryServiceMap.findAll();
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
    public @ResponseBody void addToInventory(@RequestBody Set<InventoryChangeRequest> toChange) {

        toChange.forEach(entry -> {
            Inventory temp = inventoryServiceMap.findByPartId(entry.getPartId());
            temp.setInventory(temp.getInventory() + entry.getToChangeAmount());
            inventoryServiceMap.save(temp);
        });

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
    public @ResponseBody void subtractFromInventory(@RequestBody Set<InventoryChangeRequest> toChange){

        toChange.forEach(entry -> {
            Inventory temp = inventoryServiceMap.findByPartId(entry.getPartId());
            temp.setInventory(temp.getInventory() - entry.getToChangeAmount());
            inventoryServiceMap.save(temp);
        });

    }

}
