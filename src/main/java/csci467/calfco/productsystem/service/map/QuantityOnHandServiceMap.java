package csci467.calfco.productsystem.service.map;

import csci467.calfco.productsystem.models.QuantityOnHand;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuantityOnHandServiceMap extends AbstractMapService<QuantityOnHand, Long> {

    @Override
    public Set<QuantityOnHand> findAll() {
        return super.findAll();
    }

    @Override
    public QuantityOnHand findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public QuantityOnHand save(QuantityOnHand object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(QuantityOnHand object) {
        super.delete(object);
    }
}

/*

 */
