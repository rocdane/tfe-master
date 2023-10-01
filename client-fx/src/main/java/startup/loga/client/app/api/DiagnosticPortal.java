package startup.loga.client.app.api;

import com.google.gson.reflect.TypeToken;

import startup.loga.client.model.Diagnosis;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticPortal extends HttpRequestHelper {

    public Diagnosis create(Diagnosis diagnosis) throws IOException, InterruptedException {
        return (Diagnosis) request("/maintenance-service/diagnosis","POST", diagnosis, Diagnosis.class);
    }

    public Diagnosis read(Long id) throws IOException, InterruptedException {
        return (Diagnosis) request("/maintenance-service/diagnosis/"+id,"GET", null, Diagnosis.class);
    }

    public List read() throws IOException, InterruptedException {
        return request("/maintenance-service/diagnosis","GET",null, new TypeToken<ArrayList<Diagnosis>>(){}.getType());
    }
}
