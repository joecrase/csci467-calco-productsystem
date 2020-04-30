package csci467.calfco.productsystem.repository;

import csci467.calfco.productsystem.models.CreditCardAuthRequest;
import csci467.calfco.productsystem.models.CreditCardAuthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository("creditCardAuthRepository")
@PropertySource("classpath:datasource.properties")
public class CreditCardAuthRepositoryImpl implements CreditCardAuthRepository {

    @Value("${calfco.creditcardauth.url}")
    private String url;

    @Override
    public CreditCardAuthResponse sendRequest(CreditCardAuthRequest request) {

        CreditCardAuthResponse creditCardAuthResponse = new CreditCardAuthResponse();

        RestTemplate restTemplate = new RestTemplate();

        creditCardAuthResponse = restTemplate.postForObject(this.getUrl(), request, CreditCardAuthResponse.class);

        return creditCardAuthResponse;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
