package startup.loga.client.app.api;

import startup.loga.client.model.Atelier;
import startup.loga.client.model.Dossier;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;

public class GaragePortal extends HttpRequestHelper {

    public Atelier create(Atelier atelier) throws IOException, InterruptedException {
        return (Atelier) request("/loga/v1/atelier/create","POST", atelier, Atelier.class);
    }
}
