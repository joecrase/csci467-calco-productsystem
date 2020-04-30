package csci467.calfco.productsystem.service.map;

import csci467.calfco.productsystem.models.Customer;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomerServiceMap extends AbstractMapService<Customer, Long>{

    @Override
    public Set<Customer> findAll() {
        return super.findAll();
    }

    @Override
    public Customer findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Customer save(Customer object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Customer object) {
        super.delete(object);
    }


}
