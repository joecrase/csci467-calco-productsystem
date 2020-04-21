package csci467.calfco.productsystem.service.map;

import csci467.calfco.productsystem.models.ShippingCost;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ShippingCostServiceMap extends AbstractMapService<ShippingCost, Long> {
    @Override
    public Set<ShippingCost> findAll() {
        return super.findAll();
    }

    @Override
    public ShippingCost findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public ShippingCost save(ShippingCost object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(ShippingCost object) {
        super.delete(object);
    }

    public ShippingCost findByWeight(float weight){

        AtomicReference<ShippingCost> found = new AtomicReference<>(new ShippingCost());

        map.forEach((key, value) -> {
            if (value.getMaxWeight() == weight)
                found.set(value);
        });

        return found.get();
    }
}
