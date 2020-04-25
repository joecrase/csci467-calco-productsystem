package csci467.calfco.productsystem.service;

import csci467.calfco.productsystem.models.Part;
import csci467.calfco.productsystem.repository.PartRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService{


    @Qualifier("partRepository")
    private PartRepository partRepository;

    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }


    public List<Part> getAllParts() {return this.partRepository.getAllParts();}

    public Part getPartById(int partId) {return this.partRepository.getPartById(partId);}
}
