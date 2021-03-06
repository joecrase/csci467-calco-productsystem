package csci467.calfco.productsystem.repository;

import csci467.calfco.productsystem.models.Part;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository  {

    List<Part> getAllParts();

    Part getPartById(int partId);
}
