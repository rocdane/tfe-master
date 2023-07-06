package startup.loga.client.app.factory;

public class Dysfunction implements IDysfunction{

    // assign reference to dysfunction
    protected String reference;

    // describe the dysfunction
    protected String description;

    public Dysfunction(String description) {
        this.description = description;
    }

    @Override
    public String reference() {
        return reference;
    }

    @Override
    public String description() {
        return description;
    }
}
