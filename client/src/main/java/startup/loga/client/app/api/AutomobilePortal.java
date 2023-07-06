package startup.loga.client.app.api;

import com.google.gson.reflect.TypeToken;
import startup.loga.client.model.Automobile;
import startup.loga.client.model.Client;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutomobilePortal extends HttpRequestHelper {

    public Automobile create(Automobile automobile) throws IOException, InterruptedException {
        return (Automobile) request("/loga/v1/automobile/create","POST",automobile,Automobile.class);
    }

    public Automobile read(Long id) throws IOException, InterruptedException {
        return (Automobile) request("/loga/v1/automobile/read/"+id,"GET",null,Automobile.class);
    }

    public Automobile find(String immatriculation) throws IOException, InterruptedException {
        return (Automobile) request("/loga/v1/automobile/read/"+immatriculation,"GET",null,Automobile.class);
    }

    public List<Automobile> list() throws IOException, InterruptedException {
        return (List<Automobile>) request("/loga/v1/automobile/read","GET",null, new TypeToken<ArrayList<Automobile>>(){}.getType());
    }

    public Automobile edit(Automobile client, Long id) throws IOException, InterruptedException {
        return (Automobile) request("/loga/v1/automobile/edit/"+id,"PUT",client,Automobile.class);
    }

    public void delete(Long id) throws IOException, InterruptedException {
        request("/loga/v1/automobile/delete/"+id,"POST",null);
    }
}
