package csci467.calfco.productsystem.service.map;

import csci467.calfco.productsystem.models.Inventory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class InventoryServiceMap extends AbstractMapService<Inventory, Long> {

    @Override
    public Set<Inventory> findAll() {
        return super.findAll();
    }

    @Override
    public Inventory findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Inventory save(Inventory object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void delete(Inventory object) {
        super.delete(object);
    }

    public Inventory findByPartId(int partId){

        final Inventory[] temp = {new Inventory()};

        super.map.values().forEach(inventory -> {
            if(inventory.getPart().getId() == partId){
                temp[0] = inventory;
            }
        });

        return temp[0];
    }
}

/*

 */
