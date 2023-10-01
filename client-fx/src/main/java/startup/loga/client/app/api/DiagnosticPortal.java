package startup.loga.client.app.api;

import com.google.gson.reflect.TypeToken;
import startup.loga.client.app.factory.Diagnosis;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticPortal extends HttpRequestHelper {

    public startup.loga.client.model.Diagnosis create(startup.loga.client.model.Diagnosis diagnosis) throws IOException, InterruptedException {
        return (startup.loga.client.model.Diagnosis) request("/maintenance-service/diagnosis","POST", diagnosis, startup.loga.client.model.Diagnosis.class);
    }

    public startup.loga.client.model.Diagnosis read(Long id) throws IOException, InterruptedException {
        return (startup.loga.client.model.Diagnosis) request("/maintenance-service/diagnosis/"+id,"GET", null, startup.loga.client.model.Diagnosis.class);
    }

    public List processDiagnosis(String words) throws IOException, InterruptedException {
        return request("/intelligent-service/resolve/"+words,"GET",null, new TypeToken<ArrayList<Diagnosis>>(){}.getType());
    }
}
