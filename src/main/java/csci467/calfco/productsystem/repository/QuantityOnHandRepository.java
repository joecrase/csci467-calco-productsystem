package csci467.calfco.productsystem.repository;

import csci467.calfco.productsystem.models.QuantityOnHand;
import csci467.calfco.productsystem.repository.custom.CustomQuantityOnHandRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityOnHandRepository extends CrudRepository<QuantityOnHand, Integer>, CustomQuantityOnHandRepository {
}
