package csci467.calfco.productsystem.repository;

import csci467.calfco.productsystem.models.CreditCardAuthRequest;
import csci467.calfco.productsystem.models.CreditCardAuthResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("creditCardAuthRepository")
public class CreditCardAuthRepositoryImpl implements CreditCardAuthRepository {


    @Override
    public CreditCardAuthResponse sendRequest(CreditCardAuthRequest request) {

        String url = "http://blitz.cs.niu.edu/CreditCard/";

        CreditCardAuthResponse creditCardAuthResponse = new CreditCardAuthResponse();

        RestTemplate restTemplate = new RestTemplate();

        creditCardAuthResponse = restTemplate.postForObject(url, request, CreditCardAuthResponse.class);

        return creditCardAuthResponse;
    }
}
