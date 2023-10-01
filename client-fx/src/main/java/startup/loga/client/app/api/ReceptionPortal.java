package startup.loga.client.app.api;

import com.google.gson.reflect.TypeToken;
import startup.loga.client.model.Diagnosis;
import startup.loga.client.model.Reception;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReceptionPortal extends HttpRequestHelper {
    public Reception create(Reception reception) throws IOException, InterruptedException {
        return (Reception) request("/maintenance-service/receptions","POST",reception,Reception.class);
    }

    public Reception read(Long id) throws IOException, InterruptedException {
        return (Reception) request("/maintenance-service/receptions/"+id,"GET",null,Reception.class);
    }

    public List read() throws IOException, InterruptedException {
        return request("/maintenance-service/receptions","GET",null, new TypeToken<ArrayList<Reception>>(){}.getType());
    }
}
