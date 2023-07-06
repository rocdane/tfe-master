package startup.loga.client.app.api;

import com.google.gson.reflect.TypeToken;
import startup.loga.client.model.Client;
import startup.loga.client.model.Dossier;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientPortal extends HttpRequestHelper {

    public Client create(Client client) throws IOException, InterruptedException {
        return (Client) request("/loga/v1/client/create","POST",client,Client.class);
    }

    public Client read(Long id) throws IOException, InterruptedException {
        return (Client) request("/loga/v1/client/read/"+id,"GET",null,Client.class);
    }

    public Client find(String name) throws IOException, InterruptedException {
        return (Client) request("/loga/v1/client/read/"+name,"GET",null,Client.class);
    }

    public List<Client> list() throws IOException, InterruptedException {
        return (List<Client>) request("/loga/v1/client/read","GET",null,new TypeToken<ArrayList<Client>>(){}.getType());
    }

    public Client edit(Client client, Long id) throws IOException, InterruptedException {
        return (Client) request("/loga/v1/client/edit/"+id,"PUT",client,Client.class);
    }

    public void delete(Long id) throws IOException, InterruptedException {
        request("/loga/v1/client/delete/"+id,"POST",null);
    }
}
