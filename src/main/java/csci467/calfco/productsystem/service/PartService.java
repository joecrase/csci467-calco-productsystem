package csci467.calfco.productsystem.service;

import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PartService {

    @Autowired
    @Qualifier("partRepository")
    private PartRepository partRepository;

    public Collection<Part> getAllParts() {return this.partRepository.getAllParts();}
}
