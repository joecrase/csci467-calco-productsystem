package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.service.PartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/parts")
public class PartController {


    PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Part> getAllParts(){

        return partService.getAllParts();
    }

}
