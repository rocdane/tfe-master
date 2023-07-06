package startup.loga.client.app.api;

import com.google.gson.reflect.TypeToken;
import startup.loga.client.model.Dossier;
import startup.loga.client.model.Profile;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourcePortal extends HttpRequestHelper {

    public Profile create(Profile profile) throws IOException, InterruptedException {
        return (Profile) request("/loga/v1/resource/profile","POST",profile, Profile.class);
    }

    public List list() throws IOException, InterruptedException {
        return request("/loga/v1/resource/profiles","GET",null,new TypeToken<ArrayList<Profile>>(){}.getType());
    }

    public List list(String txt) throws IOException, InterruptedException {
        return request("/loga/v1/resource/profiles/"+txt,"GET",null,new TypeToken<ArrayList<Profile>>(){}.getType());
    }

    public Profile read(Long id) throws IOException, InterruptedException {
        return (Profile) request("/loga/v1/resource/profile/"+id,"GET",null, Profile.class);
    }

    public Profile read(String name) throws IOException, InterruptedException {
        return (Profile) request("/loga/v1/resource/profile/"+name,"GET",null, Profile.class);
    }

    public void edit(Profile up, Long id) throws IOException, InterruptedException {
       request("/loga/v1/resource/profile/"+id,"PUT",up);
    }

    public void delete(Long id) throws IOException, InterruptedException {
        request("/loga/v1/resource/profile/"+id,"POST",null);
    }
}
