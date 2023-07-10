package startup.loga.client.app.api;

import com.google.gson.reflect.TypeToken;
import startup.loga.client.model.Automobile;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutomobilePortal extends HttpRequestHelper {

    public Automobile create(Automobile automobile) throws IOException, InterruptedException {
        return (Automobile) request("/customer-service/automobiles","POST",automobile,Automobile.class);
    }

    public Automobile read(Long id) throws IOException, InterruptedException {
        return (Automobile) request("/customer-service/automobiles/"+id,"GET",null,Automobile.class);
    }

    public Automobile findByNumber(String immatriculation) throws IOException, InterruptedException {
        return (Automobile) request("/customer-service/automobiles/number/"+immatriculation,"GET",null,Automobile.class);
    }

    public Automobile findByVin(String vin) throws IOException, InterruptedException {
        return (Automobile) request("/customer-service/automobiles/vin/"+vin,"GET",null,Automobile.class);
    }

    public List<Automobile> list() throws IOException, InterruptedException {
        return (List<Automobile>) request("/customer-service/automobiles","GET",null, new TypeToken<ArrayList<Automobile>>(){}.getType());
    }

    public void edit(Automobile client, Long id) throws IOException, InterruptedException {
        request("/customer-service/automobiles/"+id,"PUT",client,Automobile.class);
    }

    public void delete(Long id) throws IOException, InterruptedException {
        request("/customer-service/automobiles/"+id,"POST",null);
    }
}
