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
        return (Client) request("/customer-service/clients","POST",client,Client.class);
    }

    public Client read(Long id) throws IOException, InterruptedException {
        return (Client) request("/customer-service/clients/"+id,"GET",null,Client.class);
    }

    public Client find(String name) throws IOException, InterruptedException {
        return (Client) request("/customer-service/clients/name/"+name,"GET",null,Client.class);
    }

    public List<Client> list() throws IOException, InterruptedException {
        return (List<Client>) request("/customer-service/clients","GET",null,new TypeToken<ArrayList<Client>>(){}.getType());
    }

    public Client edit(Client client, Long id) throws IOException, InterruptedException {
        return (Client) request("/customer-service/clients/"+id,"PUT",client,Client.class);
    }

    public void delete(Long id) throws IOException, InterruptedException {
        request("/customer-service/clients/"+id,"POST",null);
    }
}
