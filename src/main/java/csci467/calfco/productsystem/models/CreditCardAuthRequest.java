package csci467.calfco.productsystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity @IdClass(CreditCardAuthRequestId.class)
public class CreditCardAuthRequest {

    @Id
    private String vendor; // this might not need to be an ID
    @Id
    private String trans;
    private String cc; // has to be 6011123443211234
    private String name;
    private String exp;
    private Float amount;

    public CreditCardAuthRequest() {
    }

    public CreditCardAuthRequest(String vendor, String trans, String cc, String name, String exp, Float amount) {
        this.vendor = vendor;
        this.trans = trans;
        this.cc = cc;
        this.name = name;
        this.exp = exp;
        this.amount = amount;
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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCardAuthRequest that = (CreditCardAuthRequest) o;

        if (!Objects.equals(vendor, that.vendor)) return false;
        return Objects.equals(trans, that.trans);
    }

    @Override
    public int hashCode() {
        int result = vendor != null ? vendor.hashCode() : 0;
        result = 31 * result + (trans != null ? trans.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreditCardAuthRequest{" +
                "vendor='" + vendor + '\'' +
                ", trans='" + trans + '\'' +
                ", cc='" + cc + '\'' +
                ", name='" + name + '\'' +
                ", exp='" + exp + '\'' +
                ", amount=" + amount +
                '}';
    }
}
