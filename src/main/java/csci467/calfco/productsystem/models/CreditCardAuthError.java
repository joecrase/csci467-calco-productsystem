package csci467.calfco.productsystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCardAuthError {
    @Id
    private Long id;
    private String error;

    public CreditCardAuthError() {
    }

    public CreditCardAuthError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
