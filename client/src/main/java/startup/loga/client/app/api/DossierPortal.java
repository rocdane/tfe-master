package startup.loga.client.app.api;

import com.google.gson.reflect.TypeToken;
import startup.loga.client.model.Dossier;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DossierPortal extends HttpRequestHelper {
    public Dossier create(Dossier dossier) throws IOException, InterruptedException {
        return (Dossier) request("/loga/v1/dossier/create","POST",dossier,Dossier.class);
    }

    public Dossier read(Long id) throws IOException, InterruptedException {
        return (Dossier) request("/loga/v1/dossier/find/"+id,"GET",null,Dossier.class);
    }

    public Dossier read(String reference) throws IOException, InterruptedException {
        return (Dossier) request("/loga/v1/dossier/read/"+reference,"GET",null,Dossier.class);
    }

    public List read() throws IOException, InterruptedException {
        return request("/loga/v1/dossier/list","GET",null,new TypeToken<ArrayList<Dossier>>(){}.getType());
    }

    public Dossier edit(Dossier dossier, Long id) throws IOException, InterruptedException {
        return (Dossier) request("/loga/v1/dossier/edit/"+id,"PUT",dossier, Dossier.class);
    }

    public void delete(Long id) throws IOException, InterruptedException {
        request("/loga/v1/dossier/delete/"+id,"POST",null);
    }
}
