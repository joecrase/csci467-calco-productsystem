package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.QuantityOnHand;
import csci467.calfco.productsystem.service.QuantityOnHandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/quantityOnHand")
public class QuantityOnHandController {

    private QuantityOnHandService quantityOnHandService;

    public QuantityOnHandController(QuantityOnHandService quantityOnHandService) {
        this.quantityOnHandService = quantityOnHandService;
    }

    @GetMapping(path = "/all")
    public List<QuantityOnHand> getAll(){



        return null;
    }

}
