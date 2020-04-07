package csci467.calfco.productsystem.controller;

import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/parts")
public class PartController {

    @Autowired
    PartRepository partRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Part> getAllParts(){

        return partRepository.getAllParts();
    }

}
