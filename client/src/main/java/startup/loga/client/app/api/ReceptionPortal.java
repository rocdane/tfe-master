package startup.loga.client.app.api;

import startup.loga.client.model.Reception;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;

public class ReceptionPortal extends HttpRequestHelper {
    public Reception create(Reception reception) throws IOException, InterruptedException {
        return (Reception) request("/loga/v1/reception/create","POST",reception,Reception.class);
    }

    public Reception read(Long id) throws IOException, InterruptedException {
        return (Reception) request("/loga/v1/reception/read/"+id,"GET",null,Reception.class);
    }
}
