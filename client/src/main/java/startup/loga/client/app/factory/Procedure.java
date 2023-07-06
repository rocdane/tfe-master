package startup.loga.client.app.factory;

public class Procedure implements IProcedure{

    // assign reference to procedure
    protected String reference;

    // describe the procedure
    protected String description;

    public Procedure(String description) {
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
