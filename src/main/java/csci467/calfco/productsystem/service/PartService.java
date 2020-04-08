package csci467.calfco.productsystem.service;

import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.repository.PartRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PartService {


    @Qualifier("partRepository")
    private PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public Collection<Part> getAllParts() {return this.partRepository.getAllParts();}
}
