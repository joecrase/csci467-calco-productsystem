package csci467.calfco.productsystem.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class CreditCardAuthResponse {

    @Id
    @JsonProperty("authorization")
    private String authorization;
    @JsonProperty("vendor")
    private String vendor;
    @JsonProperty("trans")
    private String trans;
    @JsonProperty("cc")
    private String cc;
    @JsonProperty("name")
    private String name;
    @JsonProperty("exp")
    private String exp;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("_id")
    private String _id;
    @OneToMany
    @JsonProperty("errors")
    private Set<CreditCardAuthError> errors = new HashSet<>();

    public CreditCardAuthResponse() {
    }

    public CreditCardAuthResponse(String vendor, String trans, String cc, String name, String exp, String brand, String authorization, String timeStamp, String _id, Set<CreditCardAuthError> errors) {
        this.vendor = vendor;
        this.trans = trans;
        this.cc = cc;
        this.name = name;
        this.exp = exp;
        this.brand = brand;
        this.authorization = authorization;
        this.timeStamp = timeStamp;
        this._id = _id;
        this.errors = errors;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Set<CreditCardAuthError> getErrors() {
        return errors;
    }

    public void setErrors(Set<CreditCardAuthError> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCardAuthResponse that = (CreditCardAuthResponse) o;

        return Objects.equals(authorization, that.authorization);
    }

    @Override
    public int hashCode() {
        return authorization != null ? authorization.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CreditCardAuthResponse{" +
                "vendor='" + vendor + '\'' +
                ", trans='" + trans + '\'' +
                ", cc='" + cc + '\'' +
                ", name='" + name + '\'' +
                ", exp='" + exp + '\'' +
                ", brand='" + brand + '\'' +
                ", authorization='" + authorization + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
