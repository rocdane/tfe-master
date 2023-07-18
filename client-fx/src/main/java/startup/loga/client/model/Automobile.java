package startup.loga.client.model;

import java.io.Serializable;
public class Automobile implements Serializable
{
    private Long id;
    private String number;
    private String vin;
    private String make;
    private String model;
    private Integer trim;
    private String unit;

    public Automobile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getTrim() {
        return trim;
    }

    public void setTrim(Integer trim) {
        this.trim = trim;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
