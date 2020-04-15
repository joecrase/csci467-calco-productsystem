package csci467.calfco.productsystem.service;

import csci467.calfco.productsystem.repository.QuantityOnHandRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QuantityOnHandService {

    @Qualifier("quantityOnHandRepository")
    private QuantityOnHandRepository quantityOnHandRepository;

    public QuantityOnHandService(QuantityOnHandRepository quantityOnHandRepository) {
        this.quantityOnHandRepository = quantityOnHandRepository;
    }

}
