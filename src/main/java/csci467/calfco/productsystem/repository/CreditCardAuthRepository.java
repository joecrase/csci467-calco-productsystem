package csci467.calfco.productsystem.repository;

import csci467.calfco.productsystem.models.CreditCardAuthRequest;
import csci467.calfco.productsystem.models.CreditCardAuthResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardAuthRepository {

    CreditCardAuthResponse sendRequest(CreditCardAuthRequest request);
}
