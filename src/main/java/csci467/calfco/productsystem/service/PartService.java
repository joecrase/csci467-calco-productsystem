package csci467.calfco.productsystem.service;

import csci467.calfco.productsystem.models.Part;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PartService {
    List<Part> getAllParts();
}
