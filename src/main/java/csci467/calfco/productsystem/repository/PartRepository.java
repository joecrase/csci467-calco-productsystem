package csci467.calfco.productsystem.repository;

import csci467.calfco.productsystem.models.Part;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PartRepository  {

    Collection<Part> getAllParts();
}
