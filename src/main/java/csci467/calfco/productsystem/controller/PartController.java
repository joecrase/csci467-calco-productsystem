package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.service.PartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/parts")
public class PartController {


    PartServiceImpl partService;

    public PartController(PartServiceImpl partService) {
        this.partService = partService;
    }

    @GetMapping(path = "/all")
    public @ResponseBody List<Part> getAllParts(){

        return partService.getAllParts();
    }

}
