package csci467.calfco.productsystem.service.map;

import csci467.calfco.productsystem.models.Order;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderServiceMap extends AbstractMapService<Order, Long> {

    @Override
    public Set<Order> findAll() {
        return super.findAll();
    }

    @Override
    public Order findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Order save(Order object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Order object) {
        super.delete(object);
    }
}
