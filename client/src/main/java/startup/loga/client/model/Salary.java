package startup.loga.client.model;

import java.io.Serializable;
import java.util.Date;

public class Salary implements Serializable {

    private Long id;
    private Integer prime;
    private Integer indemnity;
    private Integer additional;
    private Integer tax;
    private String mode;
    private String reference;
    private Integer amount;
    private Date date;
    private Profile profile;

    public Salary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrime() {
        return prime;
    }

    public void setPrime(Integer prime) {
        this.prime = prime;
    }

    public Integer getIndemnity() {
        return indemnity;
    }

    public void setIndemnity(Integer indemnity) {
        this.indemnity = indemnity;
    }

    public Integer getAdditional() {
        return additional;
    }

    public void setAdditional(Integer additional) {
        this.additional = additional;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
