package csci467.calfco.productsystem.service;

import csci467.calfco.productsystem.models.CreditCardAuthRequest;
import csci467.calfco.productsystem.models.CreditCardAuthResponse;
import csci467.calfco.productsystem.repository.CreditCardAuthRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CreditCardAuthService {

    @Qualifier("creditCardAuthRepository")
    private CreditCardAuthRepository creditCardAuthRepository;

    public CreditCardAuthService(CreditCardAuthRepository creditCardAuthRepository) {
        this.creditCardAuthRepository = creditCardAuthRepository;
    }

    public CreditCardAuthResponse sendRequest(CreditCardAuthRequest request) {
        return creditCardAuthRepository.sendRequest(request);
    }
}
