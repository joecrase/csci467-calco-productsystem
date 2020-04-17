package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.models.QuantityOnHand;
import csci467.calfco.productsystem.service.map.QuantityOnHandServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/quantityOnHand")
public class QuantityOnHandController {

    QuantityOnHandServiceMap quantityOnHandServiceMap;

    public QuantityOnHandController(QuantityOnHandServiceMap quantityOnHandServiceMap) {
        this.quantityOnHandServiceMap = quantityOnHandServiceMap;
    }

    // TODO: Implement incrementing and decrementing inventory via two api calls (might be sent as a list)
    // TODO: Add call to get inventory amount for a specific part

    @GetMapping(path = {"", "/", "index"})
    public List<Part> initializeQuantityOnHand(){

        return null;
    }

    // Might change QuantityOnHand model to store the entirety of the parts information
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<QuantityOnHand> getAll(){

        return quantityOnHandServiceMap.findAll();
    }

}
